package com.sxg.leetcode.question.data2020_10;

/**
 * @ClassName: LCP19
 * @Author: Su_N
 * @Date: 2020/10/1 19:34
 * @Description: LCP 19. 秋叶收藏集 [动态规划]
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
