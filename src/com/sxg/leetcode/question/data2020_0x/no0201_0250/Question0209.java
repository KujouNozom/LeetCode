package com.sxg.leetcode.question.data2020_0x.no0201_0250;

/**
 * @ClassName: Question0209
 * @Author: Su_N
 * @Date: 2020/6/24 20:37
 * @Description: 通过一个sum数组计算和，可以使用二分查找，因为是正整数，sum数组第递增的
 * 也可以使用双指针，这里我们使用双指针
 * 初始化两个指针都指向第一个节点，移动一个指针向后，计算sum数组，sum大于目标之后，记录最小长度，移动前面的指针
 * 每次执行，移动前面指针，如果sum小于目标，移动后面指针直到大于目标；如果大于目标，不移动后面指针
 * 然后计算当前长度和最小长度，那个小，赋值给最小长度
 *
 * 209. 长度最小的子数组
 *
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回 0。
 *
 * 示例:
 *
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 *
 * 进阶:
 *
 * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 */
public class Question0209 {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] sums = new int[nums.length];
        int min = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        int currentSum = 0;

        for (; rightIndex < nums.length; rightIndex++) {
            currentSum = currentSum + nums[rightIndex];
            sums[rightIndex] = currentSum;
            if (sums[rightIndex] >= s) {
                min = rightIndex + 1;
                break;
            }
        }

        if (rightIndex == nums.length && currentSum < s) {
            return 0;
        }

        for (; leftIndex < rightIndex; leftIndex++) {
            if (sums[rightIndex] - sums[leftIndex] < s) {
                while (sums[rightIndex] - sums[leftIndex] < s) {
                    rightIndex++;
                    if (rightIndex >= nums.length) {
                        return min;
                    }

                    currentSum = currentSum + nums[rightIndex];
                    sums[rightIndex] = currentSum;
                }

            }

            min = Math.min(rightIndex - leftIndex, min);
        }

        return min;
    }
}
