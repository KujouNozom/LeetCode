package com.sxg.leetcode.question.data2020_0x.no0301_0350;

/**
 * @ClassName: Question0304
 * @Author: Su_N
 * @Date: 2020/7/15 22:24
 * @Description: 初始化临时矩阵
 * 初始化一个以0,0开始的到其他每个点的矩阵的和
 * 计算的时候a,b,c,d(左上到左下)四个点矩阵的和，等于0,c + 0,(a左上角) - 0,(b上) - 0,(d左)
 * 304. 二维区域和检索 - 矩阵不可变
 *
 * 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2)。
 *
 * Range Sum Query 2D
 * 上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。
 *
 * 示例:
 *
 * 给定 matrix = [
 * [3, 0, 1, 4, 2],
 * [5, 6, 3, 2, 1],
 * [1, 2, 0, 1, 5],
 * [4, 1, 0, 1, 7],
 * [1, 0, 3, 0, 5]
 * ]
 *
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 *
 * 说明:
 *
 * 你可以假设矩阵不可变。
 * 会多次调用 sumRegion 方法。
 * 你可以假设 row1 ≤ row2 且 col1 ≤ col2。
 */
public class Question0304 {
    public static void main(String[] args) {
        NumMatrix demo = new NumMatrix(new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        }
        );

        demo.sumRegion(2, 1, 4, 3);
    }

}

class NumMatrix {
    private int[][] temp;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        this.temp = new int[matrix.length + 1][matrix[0].length + 1];

        for (int i = 0; i < matrix.length; i++) {
            int tempRow = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                tempRow = tempRow + matrix[i][j];
                temp[i + 1][j + 1] = temp[i + 1 - 1][j + 1] + tempRow;
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (temp == null || temp.length == 0 || temp[0].length == 0) {
            return 0;
        }
        return temp[row2 + 1][col2 + 1] + temp[row1 + 1 - 1][col1 + 1 - 1] - temp[row1 + 1 - 1][col2 + 1] - temp[row2 + 1][col1 + 1 - 1];
    }
}
