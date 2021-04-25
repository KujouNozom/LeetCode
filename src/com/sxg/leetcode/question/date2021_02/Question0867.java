package com.sxg.leetcode.question;

/**
 * @ClassName: Question0867
 * @Author: Su_N
 * @Date: 2021/2/25 22:58
 * @Description: 867. 转置矩阵
 */
public class Question0867 {
    public int[][] transpose(int[][] matrix) {
        int rowCount = matrix.length;
        int colCount = matrix[0].length;

        int[][] ans = new int[colCount][rowCount];
        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < colCount; col++) {
                ans[col][row] = matrix[row][col];
            }
        }

        return ans;
    }
}
