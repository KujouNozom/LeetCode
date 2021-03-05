package com.sxg.leetcode.question.data2020_05;

import java.util.Arrays;

/**
 * @ClassName: Question0016
 * @Author: Su_N
 * @Date: 2020/5/4 7:25
 * @Description: 16. 最接近的三数之和 [双指针]
 */
public class Question0016 {

    public static void main(String[] args) {
        Question0016 demo = new Question0016();
        demo.threeSumClosest(new int[] {0, 1, 2}, 3);
    }

    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }

        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int result = 0;
        int pre = nums[0] - 1;
        for (int index = 0; index <= nums.length - 3; index++) {
            if (nums[index] == pre) {
                continue;
            }

            int temp = target - nums[index];
            int leftIndex = index + 1;
            int rightIndex = nums.length - 1;

            while (leftIndex < rightIndex) {
                int addResult = nums[leftIndex] + nums[rightIndex];
                if (addResult == temp) {
                    return target;
                }

                if (min > Math.abs(temp - addResult)) {
                    min = Math.abs(temp - addResult);
                    result = addResult + nums[index];
                }

                if (addResult > temp) {
                    rightIndex--;
                    continue;
                }

                if (addResult < temp) {
                    leftIndex++;
                    continue;
                }
            }

            pre = nums[index];
        }

        return result;
    }
}
