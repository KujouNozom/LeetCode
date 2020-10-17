package com.sxg.leetcode.question.no0001_0050;

import java.util.HashMap;


/**
 * @ClassName: Question0001
 * @Author: Su_N
 * @Date: 2020/10/3 9:19
 * @Description: hash
 * 使用 hash，遍历数组每个元素 x，查找 target - x 是否存在
 * 1. 两数之和
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 *
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class Question0001 {
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        HashMap<Integer, Integer> indexes = new HashMap<>(length);

        for (int index = 0; index < length; index++) {
            int temp = nums[index];
            int ansValue = target - temp;
            if (indexes.containsKey(ansValue)) {
                return new int[]{indexes.get(ansValue), index};
            }
            indexes.put(temp, index);
        }

        return null;
    }
}
