package com.sxg.leetcode.question.data2020_0x.no0201_0250;

/**
 * @ClassName: Question0240
 * @Author: Su_N
 * @Date: 2020/7/6 22:53
 * @Description: 从左下角或者右上角开始，根据当前元素带大小，移动指针（必须是左下角或者右上角，因为这两个角的行和列分别是大于或者小于目标的元素）
 * 左下角开始的时候，大于目标值上移，小于目标值右移
 * 右上角开始的时候，大于目标值左移，小于目标值下移
 *
 *
 * 240. 搜索二维矩阵 II
 *
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 *
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 */
public class Question0240 {
    public static void main(String[] args) {
        Question0240 demo = new Question0240();
        demo.searchMatrix(new int[][]{
                        {1, 4, 7, 11, 15},
                        {2, 5, 8, 12, 19},
                        {3, 6, 9, 16, 22},
                        {10, 13, 14, 17, 24},
                        {18, 21, 23, 26, 30}
                }, 5
        );
    }


    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int colLength = matrix[0].length;
        int rowLength = matrix.length;
        int rowIndex = 0;
        int colIndex = colLength - 1;

        while (rowIndex < rowLength && colIndex >= 0) {
            if (target == matrix[rowIndex][colIndex]) {
                return true;
            }

            if (target < matrix[rowIndex][colIndex]) {
                colIndex--;
            } else {
                rowIndex++;
            }
        }
        return false;
    }


}
