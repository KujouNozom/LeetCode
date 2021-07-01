package com.sxg.leetcode.question.data2021_04;

/**
 * @ClassName: Question0303
 * @Author: Su_N
 * @Date: 2021/3/1 23:32
 * @Description: 303. 区域和检索 - 数组不可变
 */
public class Question0303 {
    class NumArray {
        private int[] preSums;

        public NumArray(int[] nums) {
            int sum = 0;
            int length = nums.length;
            this.preSums = new int[length + 1];
            this.preSums[0] = 0;
            for (int index = 0; index < length; index++) {
                sum += nums[index];
                preSums[index + 1] = sum;
            }
        }

        public int sumRange(int i, int j) {
            return preSums[j + 1] - preSums[i];
        }
    }
}
