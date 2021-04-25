package com.sxg.leetcode.question.data2020_0x.no0201_0250;

/**
 * @ClassName: Question0221
 * @Author: Su_N
 * @Date: 2020/6/28 23:51
 * @Description: 动态规划
 * f(i,j) 表示以i,j为右下角的矩形的边长最大值，通过节点以及它左，上，左上的值，可以计算出这个点的值，转移方程为
 * 1.如果data[i][j] == 0，f(i,j) = 0
 * 2.如果 data[i][j-1] == 0 || data[i-1][j] == 0 || data[i-1][j-1] == 0，f(i,j) = 1 (自己是矩形)
 * 3.f(i,j) = min(f(i-1,j),f(i,j-1),f(i-1,j-1)) + 1 (因为这个正方形的下边长度由在左面点的值决定，右边由上面点的值决定，上边和左边由左上点的值决定)
 * 初始化上和左边界的值 f(i,j) == data[i][j] = 0 ? 0 : 1
 *
 *
 *
 * 221. 最大正方形
 *
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * 输出: 4
 */
public class Question0221 {

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 0;

        for (int index = 0; index < m; index++) {
            dp[index][0] = matrix[index][0] == '0' ? 0 : 1;
            max = Math.max(max, dp[index][0]);
        }

        for (int index = 0; index < n; index++) {
            dp[0][index] = matrix[0][index] == '0' ? 0 : 1;
            max = Math.max(max, dp[0][index]);
        }


        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else if (matrix[i][j - 1] == '0' || matrix[i - 1][j] == '0' || matrix[i - 1][j - 1] == '0') {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }

        return max * max;
    }
}
