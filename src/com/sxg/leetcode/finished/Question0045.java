package com.sxg.leetcode.finished;

/**
 * @ClassName: Question0045
 * @Author: Su_N
 * @Date: 2020/4/28 13:04
 * @Description: 贪心算法
 * 45. 跳跃游戏 II
 * <p>
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * <p>
 * 说明:
 * <p>
 * 假设你总是可以到达数组的最后一个位置。
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
