package com.sxg.leetcode.question;

/**
 * @ClassName: Question0945
 * @Author: Su_N
 * @Date: 2021/2/10 20:08
 * @Description: 485. 最大连续1的个数
 */
public class Question0945 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int currentMax = 0;

        for (int num : nums) {
            if (num == 0) {
                currentMax = 0;
            } else {
                ans = Math.max(ans, ++currentMax);
            }
        }

        return ans;
    }
}
