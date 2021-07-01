package com.sxg.leetcode.question.data2021_05;

/**
 * @ClassName: Question0059
 * @Author: Su_N
 * @Date: 2020/5/8 11:22
 * @Description: 59. 螺旋矩阵 II [模拟运行的轨迹，填入数字]
 */
public class Question0059 {
    public int[][] generateMatrix(int n) {
        if (n <= 0) {
            return null;
        }

        int[][] result = new int[n][n];
        int[] fwi = {0, 1, 0, -1};
        int[] fwj = {1, 0, -1, 0};

        int fw = 0;
        int i = 0;
        int j = 0;

        for (int index = 1; index <= n * n; index++) {
            result[i][j] = index;

            int nexti = i + fwi[fw];
            int nextj = j + fwj[fw];

            if (0 <= nexti && nexti < n && 0 <= nextj && nextj < n && result[nexti][nextj] == 0) {
                i = nexti;
                j = nextj;
            } else {
                fw = (fw + 1) % 4;
                i = i + fwi[fw];
                j = j + fwj[fw];
            }
        }

        return result;
    }
}
