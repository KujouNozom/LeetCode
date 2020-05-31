package com.sxg.leetcode.finished.no0001_0050;

/**
 * @ClassName: Question0034
 * @Author: Su_N
 * @Date: 2020/5/4 18:11
 * @Description: 二分查找
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * <p>
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * <p>
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */
public class Question0034 {

    public static void main(String[] args) {
        Question0034 demo = new Question0034();
        demo.search(new int[]{5, 7, 7, 8, 8, 10}, 6, 0, 6, false);
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        if (nums.length == 1) {
            if (nums[0] == target) {
                return new int[]{0, 0};
            } else {
                return new int[]{-1, -1};
            }
        }

        return new int[]{search(nums, target, 0, nums.length - 1, true), search(nums, target, 0, nums.length - 1, false)};
    }

    private int search(int[] nums, int target, int left, int right, boolean isLeft) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (isLeft && nums[mid] == target)) {
                right = mid;

            } else {
                left = mid + 1;
            }
        }

        if (!isLeft && nums[left] != target) {
            // 因为每次nums[mid]的值==targer的时候，left = mid+1;所以最后left是右边界+1
            left = left - 1;
        }

        if (left == nums.length || left == -1 || nums[left] != target) {
            return -1;
        } else {
            return left;
        }
    }
}
