package com.sxg.leetcode.question.data2020_0x.no0051_0100;

/**
 * @ClassName: Question0073
 * @Author: Su_N
 * @Date: 2020/5/12 19:01
 * @Description: 基本方法
 * 使用矩阵的每行每列的第一个元素表示该行、列是否有0（注意第一行和第一列的第一个元素都是(0,0)，需要多一个标志位）
 * 步骤：
 * 1.遍历数组，如果(i,j)位置的元素为0，设置(i,0)和(0,j)为0，注意第一行我们使用标识为存储，把位置(0,0)留给第一列使用
 * 2.通过处理后的数组第一行，第一列的值，判断数组的行列是否需要置0
 * 73. 矩阵置零
 * <p>
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * [1,1,1],
 * [1,0,1],
 * [1,1,1]
 * ]
 * 输出:
 * [
 * [1,0,1],
 * [0,0,0],
 * [1,0,1]
 * ]
 * <p>
 * 示例 2:
 * <p>
 * 输入:
 * [
 * [0,1,2,0],
 * [3,4,5,2],
 * [1,3,1,5]
 * ]
 * 输出:
 * [
 * [0,0,0,0],
 * [0,4,5,0],
 * [0,3,1,0]
 * ]
 * <p>
 * 进阶:
 * <p>
 * 一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个常数空间的解决方案吗？
 */
public class Question0073 {
    public void setZeroes(int[][] matrix) {
        if (matrix == null) {
            return;
        }

        boolean firstRow = false;
        for (int index = 0; index < matrix[0].length; index++) {
            if (matrix[0][index] == 0) {
                firstRow = true;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }


        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }


        if (firstRow) {
            for (int index = 0; index < matrix[0].length; index++) {
                matrix[0][index] = 0;
            }
        }
    }
}
