package com.sxg.leetcode.question;

/**
 * @ClassName: Question0566
 * @Author: Su_N
 * @Date: 2021/2/17 16:34
 * @Description: 566. 重塑矩阵
 */
public class Question0566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums == null || nums.length == 0 || nums[0].length == 0) {
            return nums;
        }

        int row = nums.length;
        int col = nums[0].length;
        int count = row * col;

        if (count != r * c) {
            return nums;
        }

        int[][] ans = new int[r][c];
        for (int index = 0; index < count; index++) {
            ans[index / c][index % c] = nums[index / col][index % col];
        }

        return ans;
    }
}
