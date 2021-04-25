package com.sxg.leetcode.question.data2020_0x.no0351_0400;

/**
 * @ClassName: Question0377
 * @Author: Su_N
 * @Date: 2020/7/29 23:01
 * @Description: 背包问题，动态规划。f(i) = f(i-k1) + f(i-k2).... k1 k2是数组中元素
 * 377. 组合总和 Ⅳ
 *
 * 给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
 *
 * 示例:
 *
 * nums = [1, 2, 3]
 * target = 4
 *
 * 所有可能的组合为：
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 *
 * 请注意，顺序不同的序列被视作不同的组合。
 *
 * 因此输出为 7。
 *
 * 进阶：
 * 如果给定的数组中含有负数会怎么样？
 * 问题会产生什么变化？
 * 我们需要在题目中添加什么限制来允许负数的出现？
 *
 * 致谢：
 * 特别感谢 @pbrother 添加此问题并创建所有测试用例。
 */
public class Question0377 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int sumIndex = 1; sumIndex <= target; sumIndex++) {
            for (int index = 0; index < nums.length; index++) {
                int temp = sumIndex - nums[index];
                if (temp >= 0) {
                    dp[sumIndex] += dp[temp];
                }
            }
        }

        return dp[target];
    }
}
