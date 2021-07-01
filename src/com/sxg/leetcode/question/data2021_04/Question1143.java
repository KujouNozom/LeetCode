package com.sxg.leetcode.question.data2021_04;

/**
 * @ClassName: Question1143
 * @Author: Su_N
 * @Date: 2021/3/5 21:52
 * @Description: 1143. 最长公共子序列 [动态规划]
 */
public class Question1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int length1 = text1.length();
        int length2 = text2.length();
        char[] data1 = text1.toCharArray();
        char[] data2 = text2.toCharArray();

        int[][] dp = new int[length1 + 1][length2 + 1];

        for (int index1 = 1; index1 <= length1; index1++) {
            for (int index2 = 1; index2 <= length2; index2++) {
                if (data1[index1 - 1] == data2[index2 - 1]) {
                    dp[index1][index2] = dp[index1 - 1][index2 - 1] + 1;
                } else {
                    dp[index1][index2] = Math.max(dp[index1 - 1][index2], dp[index1][index2 - 1]);
                }
            }
        }

        return dp[length1][length2];
    }
}
