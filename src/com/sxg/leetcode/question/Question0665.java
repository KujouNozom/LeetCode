package com.sxg.leetcode.question;

/**
 * @ClassName: Question0665
 * @Author: Su_N
 * @Date: 2021/2/7 23:13
 * @Description: 665. 非递减数列
 */
public class Question0665 {
    public boolean checkPossibility(int[] nums) {
        boolean once = false;
        int length = nums.length;
        int pre = Integer.MIN_VALUE;
        for (int index = 0; index < length - 1; index++) {
            int temp = nums[index + 1] - nums[index];
            if (once && temp < 0) {
                return false;
            }

            if (!once && temp < 0) {
                // 我们可以修改 index 和 index+1 中的一个来使数组满足非递减.此外，此时的 index 的值肯定是大于 index+1 的
                // 我们需要使修改后的 index+1 尽量小，这样后面才更有可能满足条件，因此我们最好是修改 index 的值，使 index <= index+1
                // 但是，需要注意我们修改 index 的时候还需要注意 保证 index-1 <= index
                // 如果 index-1 > index+1 那么我们找不到一个值满足 index-1 <= index <= index+1
                // 此时只能修改 index+1，来使 index <= index+1 满足，index+1最小的取值是 index
                if (pre > nums[index + 1]) {
                    nums[index + 1] = nums[index];
                } else {
                    nums[index] = nums[index + 1];
                }
                once = true;
            }

            pre = nums[index];
        }

        return true;
    }
}
