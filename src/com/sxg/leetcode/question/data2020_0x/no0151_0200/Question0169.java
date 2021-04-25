package com.sxg.leetcode.question.data2020_0x.no0151_0200;

/**
 * @ClassName: Question0169
 * @Author: Su_N
 * @Date: 2020/11/20 22:50
 * @Description: 169.多数元素
 * 摩尔投票法
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 示例
 * 示例 1
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 * 题解
 * 摩尔投票法
 */
public class Question0169 {
    public int majorityElement(int[] nums) {
        int ans = 0;
        int count = 0;
        for (int temp : nums) {
            if (count == 0) {
                ans = temp;
                count++;
            } else if (ans == temp) {
                count++;
            } else {
                count--;
            }
        }

        return ans;
    }
}
