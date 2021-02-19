package com.sxg.leetcode.question.data2020_0x.no0201_0250;

/**
 * @ClassName: Question0213
 * @Author: Su_N
 * @Date: 2020/6/27 12:42
 * @Description: 动态规划
 * 我们使用动态规划，唯一要注意的是，这是一个环，第一个节点和最后一个节点会相互影响，
 * 我们以两次规划，第一次不取第一个节点，第二次不取最后一个节点
 *
 * 关于一个房子 i,f(i) 有两种情况
 * 第一种取这个房子的钱，那么，前面一个房子不取，f(i) = f(i-2) + v[i]
 * 第二种是不取这个房子的钱，f(i) = f(i-1)
 *
 * 做个优化，不需要保存每次的结果，只需要保存前两次的结果
 *
 *
 * 213. 打家劫舍 II
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 示例 1:
 *
 * 输入: [2,3,2]
 * 输出: 3
 * 解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 *
 * 示例 2:
 *
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 */
public class Question0213 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int[] maxValuesWithOutFirst = new int[2];
        int[] maxValuesWithFirst = new int[2];

        // 第一个房子不取
        maxValuesWithOutFirst[1] = 0;
        // 第一个房子取
        maxValuesWithFirst[1] = nums[0];

        for (int index = 2; index <= nums.length; index++) {
            int maxValue = Math.max(maxValuesWithOutFirst[1], maxValuesWithOutFirst[0] + nums[index - 1]);
            maxValuesWithOutFirst[0] = maxValuesWithOutFirst[1];
            maxValuesWithOutFirst[1] = maxValue;

            maxValue = Math.max(maxValuesWithFirst[1], maxValuesWithFirst[0] + nums[index - 1]);
            maxValuesWithFirst[0] = maxValuesWithFirst[1];
            maxValuesWithFirst[1] = maxValue;
        }

        return Math.max(maxValuesWithOutFirst[1], maxValuesWithFirst[0]);
    }
}
