package com.sxg.leetcode.question.data2020_0x.no0151_0200;

/**
 * @ClassName: Question0162
 * @Author: Su_N
 * @Date: 2020/6/14 13:54
 * @Description: 二分查找
 * 因为时间要求所以不能使用 线性扫描
 * 但是因为序列不是有序的，所以我们要修改下一般的二分查找
 * 我们可以把序列看成是一个由许多单调递增/递减的序列构成的
 * 每次找到中间值，和中间值右侧的值比较
 * 如果右侧值小，那么这个中间值位于一个递减的序列上面，峰值在左侧，修改范围 high = mid
 * 如果右侧值大，那么这个中间值位于一个递增的序列上面，峰值在右侧，修改范围 low = mid
 *
 *
 * 162. 寻找峰值
 *
 * 峰值元素是指其值大于左右相邻值的元素。
 *
 * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 *
 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 *
 * 你可以假设 nums[-1] = nums[n] = -∞。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1]
 * 输出: 2
 * 解释: 3 是峰值元素，你的函数应该返回其索引 2。
 *
 * 示例 2:
 *
 * 输入: nums = [1,2,1,3,5,6,4]
 * 输出: 1 或 5
 * 解释: 你的函数可以返回索引 1，其峰值元素为 2；
 * 或者返回索引 5， 其峰值元素为 6。
 *
 * 说明:
 *
 * 你的解法应该是 O(logN) 时间复杂度的。
 */
public class Question0162 {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            if (low == high) {
                return low;
            }

            int mid = (low + high) / 2;

            if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
