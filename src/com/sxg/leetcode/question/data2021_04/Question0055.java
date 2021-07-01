package com.sxg.leetcode.question.data2021_04;

/**
 * @ClassName: Question0055
 * @Author: Su_N
 * @Date: 2020/4/28 14:05
 * @Description: 55. 跳跃游戏 [贪心算法]
 */
public class Question0055 {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }

        int currentIndex = 0;
        int length = nums.length - 1;

        while (currentIndex < length) {
            if (nums[currentIndex] == 0) {
                return false;
            }

            int nextJumpMaxIndex = 0;
            int nextJumpMax = currentIndex;

            for (int i = 1; i <= nums[currentIndex]; i++) {
                int currentJumpLength = currentIndex + i;
                if (currentJumpLength >= length) {
                    return true;
                }

                if (currentJumpLength + nums[currentJumpLength] > nextJumpMax) {
                    nextJumpMaxIndex = currentJumpLength;
                    nextJumpMax = currentJumpLength + nums[currentJumpLength];
                }
            }

            currentIndex = nextJumpMaxIndex;
        }

        return false;
    }
}
