package com.sxg.leetcode.finished.no0051_0100;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Question0054
 * @Author: Su_N
 * @Date: 2020/5/7 9:28
 * @Description: 模拟运行轨迹，使用状态数组
 * 54. 螺旋矩阵
 * <p>
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * <p>
 * 示例 2:
 * <p>
 * 输入:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
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
