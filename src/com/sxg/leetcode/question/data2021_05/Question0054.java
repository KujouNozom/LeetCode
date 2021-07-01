package com.sxg.leetcode.question.data2021_05;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Question0054
 * @Author: Su_N
 * @Date: 2020/5/7 9:28
 * @Description: 54. 螺旋矩阵 [模拟运行轨迹，使用状态数组]
 */
public class Question0054 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int iMax = matrix.length;
        int jMax = matrix[0].length;
        boolean[][] status = new boolean[iMax][jMax];

        int[] fwi = {0, 1, 0, -1};
        int[] fwj = {1, 0, -1, 0};
        int fw = 0;

        int i = 0;
        int j = 0;
        for (int index = 0; index < matrix.length * matrix[0].length; index++) {
            result.add(matrix[i][j]);
            status[i][j] = true;

            int nexti = i + fwi[fw];
            int nextj = j + fwj[fw];

            if (0 <= nexti && nexti < iMax && 0 <= nextj && nextj < jMax && !status[nexti][nextj]) {
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
