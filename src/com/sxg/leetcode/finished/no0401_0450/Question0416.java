package com.sxg.leetcode.finished.no0401_0450;

/**
 * @ClassName: Question0416
 * @Author: Su_N
 * @Date: 2020/8/4 21:56
 * @Description: 动态规划，0 1 背包，目标值是总和的一半，外层是数组长度，目标值内层递增
 * 416. 分割等和子集
 *
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 *
 *     每个数组中的元素不会超过 100
 *     数组的大小不会超过 200
 *
 * 示例 1:
 *
 * 输入: [1, 5, 11, 5]
 *
 * 输出: true
 *
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *
 *
 *
 * 示例 2:
 *
 * 输入: [1, 2, 3, 5]
 *
 * 输出: false
 *
 * 解释: 数组不能分割成两个元素和相等的子集.
 */
public class Question0416 {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int sum = 0;
        for (int temp : nums) {
            sum += temp;
        }

        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;
        int length = nums.length;

        boolean[][] dp = new boolean[length][target + 1];

        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        for (int index = 1; index < length; index++) {
            for (int targetIndex = 0; targetIndex <= target; targetIndex++) {
                if (nums[index] <= targetIndex) {
                    dp[index][targetIndex] = dp[index - 1][targetIndex] || dp[index - 1][targetIndex- nums[index]];
                } else {
                    dp[index][targetIndex] = dp[index - 1][targetIndex];
                }
            }
        }

        return dp[length - 1][target];
    }
}
