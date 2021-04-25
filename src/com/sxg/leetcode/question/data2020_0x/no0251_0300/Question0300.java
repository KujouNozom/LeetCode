package com.sxg.leetcode.question.data2020_0x.no0251_0300;

/**
 * @ClassName: Question0300
 * @Author: Su_N
 * @Date: 2020/7/14 22:51
 * @Description: 动态规划
 *
 * dp[i] 表示前i个数字中的最长递增序列，且必须包含i
 * dp[i] = max(dp[j]) + 1 ,j是i之前的位置，并且 nums[i] > nums[j]，这样i和之前的序列组成新的递增序列
 * 最终的结果是max(dp[])
 * 300. 最长上升子序列
 *
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 *
 * 说明:
 *
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 *
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 */
public class Question0300 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] dp = initDP(nums);
        buildDP(nums, dp);

        return getMax(dp);
    }

    private int getMax(int[] dp) {
        int max = Integer.MIN_VALUE;
        for (int index = 0; index < dp.length; index++) {
            max = Math.max(max, dp[index]);
        }
        return max;
    }

    private void buildDP(int[] nums, int[] dp) {
        for (int index = 1; index < nums.length; index++) {
            int maxL = 0;
            for (int temp = index - 1; temp >= 0; temp--) {
                if (nums[temp] < nums[index]) {
                    maxL = Math.max(maxL, dp[temp]);
                }
            }
            dp[index] = maxL + 1;
        }
    }

    private int[] initDP(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        return dp;
    }
}
