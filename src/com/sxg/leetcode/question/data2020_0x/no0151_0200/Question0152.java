package com.sxg.leetcode.question.data2020_0x.no0151_0200;

/**
 * @ClassName: Question0152
 * @Author: Su_N
 * @Date: 2020/6/12 21:52
 * @Description: 动态规划
 * f(i) 表示以i结尾的最大乘积，f(i) = max(f(i) * ai, ai)
 * 因为符号的关系，负负得正，所以这个公式是错误的。
 * 因为f(i) 表示的是最大值，但是ai可能是负数，这个时候如果前面的乘积是一个负数的时候
 * 负负得正，可能得到一个更大的数
 *
 * 一次我们需要两个数组 fmax(i) 和 fmin(i)
 * fmax(i) = max(fmax(i) * ai, fmin(i) * ai, ai)
 * fmin(i) = min(fmax(i) * ai, fmin(i) * ai, ai)
 *
 * 152. 乘积最大子数组
 *
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 *
 *
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 *
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */
public class Question0152 {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int length = nums.length;

        int[] fmax = new int[length];
        int[] fmin = new int[length];
        fmax[0] = nums[0];
        fmin[0] = nums[0];

        int result = fmax[0];

        for (int index = 1; index < length; index++) {
            int temp = nums[index];
            fmax[index] = Math.max(Math.max(fmax[index - 1] * temp, fmin[index - 1] * temp), temp);
            fmin[index] = Math.min(Math.min(fmax[index - 1] * temp, fmin[index - 1] * temp), temp);
            result = result > fmax[index] ? result : fmax[index];
        }

        return result;
    }
}
