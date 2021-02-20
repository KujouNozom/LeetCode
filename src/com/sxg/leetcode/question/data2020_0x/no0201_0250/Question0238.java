package com.sxg.leetcode.question.data2020_0x.no0201_0250;

/**
 * @ClassName: Question0238
 * @Author: Su_N
 * @Date: 2020/7/5 20:11
 * @Description: 两个数组
 * 使用两个数组存储从左往右的乘积L和从右往左的乘积R，计算除i之外乘积的时候们只需要L[i-1]*R[i+1]
 * 可以使用输出数组替换L，然后计算R的时候,使用一个临时变量存储R的乘积，直接得出结果
 * 1.计算从左往右乘积数组ans
 * 2.声明临时变量temp = 1
 * 3.从右往左计算，计算index的时候，ans[index] = ans[index-1]*temp,temp = temp*nums[index]
 *
 * 变量2遍数组，时间复杂度O(n),使用常量空间
 *
 *
 * 238. 除自身以外数组的乘积
 *
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 *
 *
 * 示例:
 *
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 *
 *
 *
 * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
 *
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 */
public class Question0238 {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int[] anwers = new int[nums.length];
        anwers[0] = nums[0];
        for (int index = 1; index < nums.length; index++) {
            anwers[index] = anwers[index - 1] * nums[index];
        }

        int temp = 1;
        for (int index = nums.length - 1; index > 0; index--) {
            anwers[index] = anwers[index - 1] * temp;
            temp = temp * nums[index];
        }
        anwers[0] = temp;

        return anwers;
    }
}
