package com.sxg.leetcode.finished.no0001_0050;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Question0031
 * @Author: Su_N
 * @Date: 2020/4/27 22:48
 * @Description: 31. 下一个排列
 * <p>
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须原地修改，只允许使用额外常数空间。
 * <p>
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
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
            for (; j > index && nums[j] <= nums[index]; j--) ;
            int temp = nums[index];
            nums[index] = nums[j];
            nums[j] = temp;

            Arrays.sort(nums, index + 1, nums.length);
        }
    }
}
