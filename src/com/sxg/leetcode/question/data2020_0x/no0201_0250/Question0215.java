package com.sxg.leetcode.question.data2020_0x.no0201_0250;


/**
 * @ClassName: Question0215
 * @Author: Su_N
 * @Date: 2020/6/28 23:12
 * @Description: 快速排序
 * 类似快速排序，每次选取一个元素将数组分成两部分，根据这个元素的位置和k，可以判断继续去哪个数组搜索,不需要搜索左右两个区间
 * 215. 数组中的第K个最大元素
 *
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 *
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 */
public class Question0215 {
    public static void main(String[] args) {
        Question0215 demo = new Question0215();
        System.out.println(demo.findKthLargest(new int[]{7, 6, 5, 4, 3, 2, 1}, 5));
    }

    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 1) {
            return nums[0];
        }

        asc(nums, 0, nums.length - 1, nums.length - k);

        return nums[nums.length - k];
    }

    public static int ascPass(int[] datas, int low, int high) {
        int temp = datas[low];

        while (low < high) {
            while (low < high && temp < datas[high]) {
                high--;
            }

            if (low < high) {
                datas[low] = datas[high];
                low++;
            }

            while (low < high && temp >= datas[low]) {
                low++;
            }

            if (low < high) {
                datas[high] = datas[low];
                high--;
            }
        }

        datas[low] = temp;

        return low;
    }

    public static void asc(int[] datas, int low, int high, int k) {
        if (low < high) {
            int i = ascPass(datas, low, high);
            if (i < k) {
                asc(datas, i + 1, high, k);
            }
            if (i > k) {
                asc(datas, low, i - 1, k);
            }
        }
    }
}
