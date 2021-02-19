package com.sxg.leetcode.question.data2020_0x.no0051_0100;

/**
 * @ClassName: Question0074
 * @Author: Su_N
 * @Date: 2020/5/12 19:56
 * @Description: 二分查找
 * 可以转换为一维数组，0-m*n
 * i = index / n
 * j = index % n
 * <p>
 * 74. 搜索二维矩阵
 * <p>
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * <p>
 * 示例 2:
 * <p>
 * 输入:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 */
public class Question0074 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = m * n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            int i = mid / n;
            int j = mid % n;
            if (matrix[i][j] == target) {
                return true;
            }

            if (matrix[i][j] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }
}
