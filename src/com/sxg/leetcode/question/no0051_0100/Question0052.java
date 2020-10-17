package com.sxg.leetcode.question.no0051_0100;

/**
 * @ClassName: com.sxg.leetcode.question.no0051_0100.Question0052
 * @Author: Su_N
 * @Date: 2020/10/17 11:05
 * @Description: N皇后
 * 每一行只能放置一个棋子，因此我们通过循环，每行放一个棋子，可能有多个位置，进行回溯，求出满足条件的排列组合，
 * 每一行中每个位置是否可以放置棋子，可以通过这个位置的列是否满足列和两个斜角不存在棋子判断
 *
 * 使用三个n位的二进制数字 col,oblique1,oblique2 表示列，两个斜角可以放棋子的位置（1表示不可以放置，0表示可以放置）
 * col 比较容易计算，该行的那一列放置放置了棋子，那个位置（从低位到高位）的数字置为1
 * 我们通过观察发现，i行的j列如果放置了棋子，那个下一行这个位置的左下右下都不能放置，这两个位置的列分别是 j+1 和 j-1
 * 对应的二进制就是上一行中置为1的位置的左移/右移一位
 * 对于一个位置，我们通过 col | oblique1 | oblique2 结果对应位置是否是1，判断是否可以放置棋子
 * 52. N皇后 II
 *
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 上图为 8 皇后问题的一种解法。
 *
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 *
 * 示例:
 *
 * 输入: 4
 * 输出: 2
 * 解释: 4 皇后问题存在如下两个不同的解法。
 * [
 * [".Q..",  // 解法 1
 * "...Q",
 * "Q...",
 * "..Q."],
 *
 * ["..Q.",  // 解法 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 *
 *
 *
 * 提示：
 *
 * 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。
 * 当然，她横、竖、斜都可走一或 N-1 步，可进可退。（引用自 百度百科 - 皇后 ）
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
                // 这就是我们上面讲0  1调换的原因
                // 1.x & (-x) 可以求出最低位的1。通过这个性质求出当前迭代可以放置棋子的位置
                // 2.x & (x-1) 可以把最低为的1置为0。通过这性质将放置棋子的位置置为0
                int flag = temp & (-temp);
                function(row + 1, col | flag, (oblique1 | flag) << 1, (oblique2 | flag) >> 1);
                temp = temp & (temp - 1);

            }
        }
    }
}
