package com.sxg.leetcode.question;

/**
 * @ClassName: Question0643
 * @Author: Su_N
 * @Date: 2021/2/4 23:52
 * @Description: 643. 子数组最大平均数 I
 */
public class Question0643 {
    public double findMaxAverage(int[] nums, int k) {
        double windowSum = 0;
        for (int index = 0; index < k; index++) {
            windowSum += nums[index];
        }

        double ans = windowSum / k;
        int length = nums.length;

        for (int index = 0; index < length - k; index++) {
            windowSum = windowSum - nums[index] + nums[index + k];
            ans = Math.max(ans, windowSum / k);
        }
        return ans;
    }
}
