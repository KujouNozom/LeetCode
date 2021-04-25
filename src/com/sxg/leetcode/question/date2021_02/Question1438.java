package com.sxg.leetcode.question;

import java.util.TreeMap;

/**
 * @ClassName: Question1438
 * @Author: Su_N
 * @Date: 2021/2/21 10:50
 * @Description: 1438. 绝对差不超过限制的最长连续子数组
 */
public class Question1438 {
    public static void main(String[] args) {
        Question1438 demo = new Question1438();
        demo.longestSubarray(new int[]{24, 12, 71, 33, 5, 87, 10, 11, 3, 58, 2, 97, 97, 36, 32, 35, 15, 80, 24, 45, 38,
                9, 22, 21, 33, 68, 22, 85, 35, 83, 92, 38, 59, 90, 42, 64, 61, 15, 4, 40, 50, 44, 54, 25, 34, 14, 33,
                94, 66, 27, 78, 56, 3, 29, 3, 51, 19, 5, 93, 21, 58, 91, 65, 87, 55, 70, 29, 81, 89, 67, 58, 29, 68, 84,
                4, 51, 87, 74, 42, 85, 81, 55, 8, 95, 39}, 87);
    }

    public int longestSubarray(int[] nums, int limit) {
        int length = nums.length;
        TreeMap<Integer, Integer> numCounts = new TreeMap<>();
        int left = 0;
        int right = 0;
        int ans = 0;

        for (int index = 0; index < length; index++) {
            int value = nums[index];
            int count = numCounts.getOrDefault(value, 0) + 1;
            numCounts.put(value, count);
            right++;

            int currentAns = numCounts.lastKey() - numCounts.firstKey();
            if (currentAns > limit) {
                int firstValue = nums[left];
                int firstValueCount = numCounts.get(firstValue) - 1;
                if (firstValueCount == 0) {
                    numCounts.remove(firstValue);
                } else {
                    numCounts.put(firstValue, firstValueCount);
                }
                left++;
            } else {
                ans = Math.max(ans, right - left);
            }
        }

        return ans;
    }
}
