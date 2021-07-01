package com.sxg.leetcode.question.data2021_04;

/**
 * @ClassName: Question0045
 * @Author: Su_N
 * @Date: 2020/4/28 13:04
 * @Description: 45. 跳跃游戏 II [贪心算法]
 */
public class Question0045 {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int currentIndex = 0;
        int length = nums.length - 1;

        int step = 0;

        while (currentIndex < length) {
            step++;
            int nextJumpMaxIndex = 0;
            int nextJumpMax = currentIndex;

            for (int i = 1; i <= nums[currentIndex]; i++) {
                int currentJumpLength = currentIndex + i;
                if (currentJumpLength >= length) {
                    return step;
                }

                if (currentJumpLength + nums[currentJumpLength] > nextJumpMax) {
                    nextJumpMaxIndex = currentJumpLength;
                    nextJumpMax = currentJumpLength + nums[currentJumpLength];
                }
            }

            currentIndex = nextJumpMaxIndex;
        }

        return -1;
    }
}
