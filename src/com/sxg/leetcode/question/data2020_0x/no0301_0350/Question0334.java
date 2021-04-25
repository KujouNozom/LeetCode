package com.sxg.leetcode.question.data2020_0x.no0301_0350;

/**
 * @ClassName: Question0334
 * @Author: Su_N
 * @Date: 2020/7/22 21:45
 * @Description: 使用两个指针指向第一小的元素 min1,第二小的元素min2
 * 当元素 i 小于min1 的时候替换Min1，当元素大于min1, 小于min2的时候替换min2，当大于min2的时候返回
 * 334. 递增的三元子序列
 *
 * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
 *
 * 数学表达式如下:
 *
 * 如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
 * 使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
 *
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5]
 * 输出: true
 *
 * 示例 2:
 *
 * 输入: [5,4,3,2,1]
 * 输出: false
 */
public class Question0334 {
    public boolean increasingTriplet(int[] nums) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int temp : nums) {
            if (temp < min1) {
                min1 = temp;
            } else if (min1 < temp && temp < min2) {
                min2 = temp;
            } else if (min2 < temp) {
                return true;
            }
        }

        return false;
    }
}
