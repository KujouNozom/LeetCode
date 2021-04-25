package com.sxg.leetcode.question.data2020_10;

import java.util.HashMap;

/**
 * @ClassName: Question0001
 * @Author: Su_N
 * @Date: 2020/10/3 9:19
 * @Description: 1. 两数之和 [hash]
 */
public class Question0001 {
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        HashMap<Integer, Integer> indexes = new HashMap<>(length);

        for (int index = 0; index < length; index++) {
            int temp = nums[index];
            int ansValue = target - temp;
            if (indexes.containsKey(ansValue)) {
                return new int[] {indexes.get(ansValue), index};
            }
            indexes.put(temp, index);
        }

        return null;
    }
}
