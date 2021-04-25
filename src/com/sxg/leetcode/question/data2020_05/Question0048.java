package com.sxg.leetcode.question.data2020_05;

/**
 * @ClassName: Question0048
 * @Author: Su_N
 * @Date: 2020/5/5 10:22
 * @Description: 48. 旋转图像 [通过翻转组合]
 */
public class Question0048 {
    public static void main(String[] args) {
        Question0048 demo = new Question0048();
        demo.rotate(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // 右上左下翻转
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                swap(matrix, i, j, n - 1 - j, n - 1 - i);
            }
        }

        // 上下翻转
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                swap(matrix, i, j, n - 1 - i, j);
            }
        }
    }

    private void swap(int[][] matrix, int i, int j, int m, int n) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[m][n];
        matrix[m][n] = tmp;
    }
}