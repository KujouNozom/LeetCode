package com.sxg.leetcode.question.data2020_10;

/**
 * @ClassName: Question0052
 * @Author: Su_N
 * @Date: 2020/10/17 11:05
 * @Description: 52. N皇后 II [回溯]
 */
public class Question0052 {
    public static void main(String[] args) {
        new Question0052().totalNQueens(4);
    }

    private int powN;

    private int n;

    private int ans;

    public int totalNQueens(int n) {
        this.ans = 0;
        this.n = n;
        this.powN = (1 << n) - 1;
        function(0, 0, 0, 0);
        return this.ans;
    }

    private void function(int row, int col, int oblique1, int oblique2) {
        if (row == n) {
            this.ans++;
        } else {
            // 本身0的位置标示可以放置，这里取反，是为了后面更好的利用位运算的性质
            // 取反之后1的位置标示可以放置，在和2^n-1与，是为了把取反造成的超过n的1置为0
            int temp = this.powN & (~(col | oblique1 | oblique2));
            // 判断是否还有可以放置的位置
            while (temp != 0) {
                // 这里利用两个位运算的性质简化遍历，我们不需要一位一位判断是否为1来判断可放置棋子
                // 我们直接求出最低位的1，然后继续递归搜索，然后把这位置为0，然后继续找到下一个可以为1的最低位
                // 这就是我们上面讲0 1调换的原因
                // 1.x & (-x) 可以求出最低位的1。通过这个性质求出当前迭代可以放置棋子的位置
                // 2.x & (x-1) 可以把最低为的1置为0。通过这性质将放置棋子的位置置为0
                int flag = temp & (-temp);
                function(row + 1, col | flag, (oblique1 | flag) << 1, (oblique2 | flag) >> 1);
                temp = temp & (temp - 1);

            }
        }
    }
}
