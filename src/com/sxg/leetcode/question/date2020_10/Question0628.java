package com.sxg.leetcode.question.date2020_10;

import java.util.Arrays;

/**
 * @ClassName: com.sxg.leetcode.question.date2020_10.Question0628
 * @Author: Su_N
 * @Date: 2020/10/10 20:23
 * @Description: 排序
 * 求最大的三个正数和最小的两个负数（如果有），比较最大的三个正数乘积和最小两个负数以及最大正数的乘积
 *
 * 628. 三个数的最大乘积
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 *
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: 6
 *
 * 示例 2:
 * 输入: [1,2,3,4]
 * 输出: 24
 *
 * 注意:
 * 给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
 * 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。
 */
public class Question0628 {
    public int maximumProduct(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[length - 1], nums[length - 1] * nums[length - 2] * nums[length - 3]);
    }
}
