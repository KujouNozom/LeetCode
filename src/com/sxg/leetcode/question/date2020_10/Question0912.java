package com.sxg.leetcode.question.date2020_10;

/**
 * @ClassName: Question0912
 * @Author: Su_N
 * @Date: 2020/10/12 23:22
 * @Description: 快速排序
 * 912. 排序数组
 *
 * 给你一个整数数组 nums，请你将该数组升序排列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 *
 * 示例 2：
 *
 * 输入：nums = [5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 *
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 50000
 * -50000 <= nums[i] <= 50000
 */
public class Question0912 {
    public int[] sortArray(int[] nums) {
        quickSort_Asc(nums, 0, nums.length - 1);
        return nums;
    }


    /**
     * 快速排序升序一趟
     *
     * @param arr  排序数组
     * @param low  下界
     * @param high 上界
     * @return
     */
    public static int quickSortAsc_Pass(int[] arr, int low, int high) {
        Integer now = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= now) {
                high--;
            }
            if (low < high) {
                arr[low] = arr[high];
                low++;
            }
            while (low < high && arr[low] < now) {
                low++;
            }
            if (low < high) {
                arr[high] = arr[low];
                high--;
            }
        }
        arr[low] = now;
        return low;
    }

    /**
     * 快速排序升序
     *
     * @param arr  排序数组
     * @param low  下界
     * @param high 上界
     */
    public static void quickSort_Asc(int[] arr, int low, int high) {
        if (low < high) {
            int i = quickSortAsc_Pass(arr, low, high);
            quickSort_Asc(arr, low, i - 1);
            quickSort_Asc(arr, i + 1, high);
        }
    }
}
