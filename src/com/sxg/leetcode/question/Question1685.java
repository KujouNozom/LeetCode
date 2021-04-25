package com.sxg.leetcode.question;

/**
 * @ClassName: Question1685
 * @Author: Su_N
 * @Date: 2021/3/3 0:16
 * @Description: 1685. 有序数组中差绝对值之和 [前缀和，数学]
 */
public class Question1685 {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int length = nums.length;
        int[] preSum = new int[length + 1];
        preSum[0] = 0;
        for (int index = 0; index < length; index++) {
            preSum[index + 1] = preSum[index] + nums[index];
        }

        int[] ans = new int[length];
        for (int index = 0; index < length; index++) {
            ans[index] = preSum[length] - 2 * preSum[index] + (2 * index - length) * nums[index];
        }

        return ans;
    }
}
