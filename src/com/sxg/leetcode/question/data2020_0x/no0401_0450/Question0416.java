package com.sxg.leetcode.question.data2020_0x.no0401_0450;

/**
 * @ClassName: Question0416
 * @Author: Su_N
 * @Date: 2020/8/4 21:56
 * @Description: 动态规划，0 1 背包，目标值是总和的一半，外层是数组长度，目标值内层递增
 * 先求出数组元素之和，如果是奇数，直接返回false。如果是偶数,求一半的值 half，这个就是目标值
 * 这里可以再加一个判断，最大值如果大于 half 直接返回false
 *
 * dp[i][j] 是一个 boolean 数组，表示前i个元素中选取任意元素能不能让和等于j
 *
 * 初始化dp[i][0] 全部是 true,因为肯定存在不选元素，和是0
 * dp[0][nums[0]] 是true,因为只要一个物品，被选择的时候，和是这个元素的值
 *
 * 状态转移方程
 * 类似0-1背包问题，每个元素有取和不取两种情况
 * 当 nums[i] <= j 的时候，可以取,可以不取，两种只要有一个满足,就可以得出 dp[i][j] = true
 * dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]]
 * 当 nums[i] > j 的时候，只能不取，dp[i][j] = dp[i-1][j]
 * 416. 分割等和子集
 *
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 *
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
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
                    dp[index][targetIndex] = dp[index - 1][targetIndex] || dp[index - 1][targetIndex - nums[index]];
                } else {
                    dp[index][targetIndex] = dp[index - 1][targetIndex];
                }
            }
        }

        return dp[length - 1][target];
    }
}
