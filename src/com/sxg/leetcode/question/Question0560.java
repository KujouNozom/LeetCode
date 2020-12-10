package com.sxg.leetcode.question;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Question0560
 * @Author: Su_N
 * @Date: 2020/12/10 23:02
 * @Description: 前缀和，Hash
 * 我们计算前缀和数组 preSum,sum(i,j) = preSum[j] - preSum[i-1] = k,sum(i-1) = preSum[j] - k
 * 我们一边计算前缀和，一边计算答案，当我们遍历到 j 的时候，sum(i-1) = preSum[j] - k，我们在Hash中查找值是  preSum[j] - k 的数量
 * 这些值肯定是满足的，因为从前往后遍历，这些点的i肯定小于j,同时初始化Map的时候放入（0,1），因为可能当前前缀和preSum[j]刚好等于 k
 * 560. 和为K的子数组
 * 中等
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 *
 * 说明 :
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 */
public class Question0560 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> presumIndexes = new HashMap<>();
        presumIndexes.put(0, 1);
        int sum = 0;
        int length = nums.length;
        int ans = 0;
        for (int index = 0; index < length; index++) {
            sum += nums[index];
            int target = sum - k;
            ans += presumIndexes.getOrDefault(target, 0);
            presumIndexes.put(sum, presumIndexes.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
