package com.sxg.leetcode.question;

/**
 * @ClassName: Question1004
 * @Author: Su_N
 * @Date: 2021/2/19 23:24
 * @Description: 1004. 最大连续1的个数 III
 */
public class Question1004 {
    public int longestOnes(int[] A, int K) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int left = 0;
        int right = 0;
        int current = 0;
        int length = A.length;

        int ans = 0;
        for (; right < length; right++) {
            if (A[right] == 0) {
                current++;
            }

            if (current > K) {
                if (A[left] == 0) {
                    current--;
                }
                left++;
            } else {
                ans = Math.max(ans, right - left + 1);
            }
        }

        return ans;
    }
}
