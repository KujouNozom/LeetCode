package com.sxg.leetcode.question.data2021_04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Question0031
 * @Author: Su_N
 * @Date: 2020/4/27 22:48
 * @Description: 31. 下一个排列
 */
public class Question0031 {
    public static void main(String[] args) {
        Question0031 demo = new Question0031();
        int[] nums = {1, 3, 2};
        demo.nextPermutation(nums);
    }

    public void nextPermutation(int[] nums) {
        int maxIndex = nums.length - 1;
        List<Integer> tailList = new ArrayList<>();

        Integer max = null;
        int index = maxIndex;
        for (; index > 0; index--) {
            tailList.add(nums[index]);
            if (nums[index] > nums[index - 1]) {
                max = nums[index - 1];
                break;
            }
        }

        if (max == null) {
            Arrays.sort(nums);
        } else {
            index--;
            int j = nums.length - 1;
            for (; j > index && nums[j] <= nums[index]; j--);
            int temp = nums[index];
            nums[index] = nums[j];
            nums[j] = temp;

            Arrays.sort(nums, index + 1, nums.length);
        }
    }
}
