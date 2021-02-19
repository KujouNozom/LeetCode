package com.sxg.leetcode.question.data2020_0x.no0151_0200;

/**
 * @ClassName: Question0153
 * @Author: Su_N
 * @Date: 2020/6/13 16:08
 * @Description: 二分查找
 *
 * 153. 寻找旋转排序数组中的最小值
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 请找出其中最小的元素。
 *
 * 你可以假设数组中不存在重复元素。
 *
 * 示例 1:
 *
 * 输入: [3,4,5,1,2]
 * 输出: 1
 *
 * 示例 2:
 *
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 */
public class Question0153 {

    public static void main(String[] args) {
        Question0153 demo = new Question0153();
        demo.findMin(new int[]{3, 1, 2});
    }

    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        if (nums.length == 1) {
            return nums[0];
        }

        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[high] < nums[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return nums[low];
    }
}
