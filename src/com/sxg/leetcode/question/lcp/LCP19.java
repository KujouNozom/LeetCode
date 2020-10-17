package com.sxg.leetcode.question.lcp;

/**
 * @ClassName: LCP19
 * @Author: Su_N
 * @Date: 2020/10/1 19:34
 * @Description: 动态规划
 * 节点分为三种类型
 * 0：前面红色部分
 * 1：中间黄色部分
 * 2：后面红色部分
 * dp[i][j]:表示第i片叶子是类型j的时候前面i片叶子的最小变化数量
 *
 *
 * 初始状态
 * i = 0：
 * dp[0][0] = leaves[0] == r ? 0 : 1.因为第一片叶子必须是红色所以类型只有0
 * i = 1：因为前面的第一片叶子必须是类型0，而第二片叶子可以是0 1 不能是2
 * dp[1][0] = dp[0][0] + (leaves[1] == r ? 0 : 1)
 * dp[1][1] = dp[0][0] + (leaves[1] == r ? 1 : 0)
 * i = 2：可以用上面公式，但是注意i = 1 的时候没有 2这种状态
 * dp[2][0] = dp[1][0] + (leaves[2] == r ? 0 : 1)
 * dp[2][1] = max(dp[1][0] ,dp[1][1]) + (leaves[2] == r ? 1 : 0)
 * dp[2][2] = dp[1][1] + (leaves[2] == r ? 0 : 1)
 * 这里先初始化三片，因为后面都是正常情况，不用特殊处理
 *
 *
 * 转移方程，按照叶子的类型区分
 * j = 0，这个时候前面必须全部是第一部分红色的叶子，因子转移方程是
 * dp[i][0] = dp[i-1][0] + (leaves[i] == r ? 0 : 1) (j = 0)
 *
 * j = 1，这个时候前面的叶子 i-1 有两种情况，i-1 是状态 0 和 i-1 是状态 1，因此转移方程是
 * dp[i][1] = min(dp[i-1][0], dp[i-1][1]) + (leaves[i] == r ? 1 : 0)
 *
 * j = 2，这个时候前面的叶子 i-1 有两种情况，i-1 是状态 1 和 i-1 是状态 2，因此转移方程是
 * dp[i][2] = min(dp[i-1][1], dp[i-1][2]) + (leaves[i] == r ? 0 : 1)
 *
 * 最终的答案是dp[n-1][2]
 *
 * LCP 19. 秋叶收藏集
 *
 * 小扣出去秋游，途中收集了一些红叶和黄叶，他利用这些叶子初步整理了一份秋叶收藏集 leaves， 字符串 leaves 仅包含小写字符 r 和 y， 其中字符 r 表示一片红叶，字符 y 表示一片黄叶。
 * 出于美观整齐的考虑，小扣想要将收藏集中树叶的排列调整成「红、黄、红」三部分。每部分树叶数量可以不相等，但均需大于等于 1。每次调整操作，小扣可以将一片红叶替换成黄叶或者将一片黄叶替换成红叶。请问小扣最少需要多少次调整操作才能将秋叶收藏集调整完毕。
 *
 * 示例 1：
 *
 * 输入：leaves = "rrryyyrryyyrr"
 *
 * 输出：2
 *
 * 解释：调整两次，将中间的两片红叶替换成黄叶，得到 "rrryyyyyyyyrr"
 *
 * 示例 2：
 *
 * 输入：leaves = "ryr"
 *
 * 输出：0
 *
 * 解释：已符合要求，不需要额外操作
 *
 * 提示：
 *
 * 3 <= leaves.length <= 10^5
 * leaves 中只包含字符 'r' 和字符 'y'
 */
public class LCP19 {
    public static void main(String[] args) {
        LCP19 demo = new LCP19();
        demo.minimumOperations("rrryyyrryyyrr");

    }

    public int minimumOperations(String leaves) {
        int n = leaves.length();
        char[] leavesC = leaves.toCharArray();
        int[][] dp = new int[n][3];
        dp[0][0] = leavesC[0] == 'r' ? 0 : 1;
        dp[1][0] = dp[0][0] + (leavesC[1] == 'r' ? 0 : 1);
        dp[1][1] = dp[0][0] + (leavesC[1] == 'r' ? 1 : 0);
        dp[2][0] = dp[1][0] + (leavesC[2] == 'r' ? 0 : 1);
        dp[2][1] = Math.min(dp[1][0], dp[1][1]) + (leavesC[2] == 'r' ? 1 : 0);
        dp[2][2] = dp[1][1] + (leavesC[2] == 'r' ? 0 : 1);

        for (int i = 3; i < n; i++) {
            int red = leavesC[i] == 'r' ? 0 : 1;
            int yellow = leavesC[i] == 'r' ? 1 : 0;
            dp[i][0] = dp[i - 1][0] + red;
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + yellow;
            dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][2]) + red;
        }

        return dp[n - 1][2];
    }
}
