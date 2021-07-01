package com.sxg.leetcode.question;

/**
 * @ClassName: Question0995
 * @Author: Su_N
 * @Date: 2021/2/18 21:48
 * @Description: 995. K 连续位的最小翻转次数
 */
public class Question0995 {
    public int minKBitFlips(int[] A, int K) {
        int n = A.length;
        int[] diff = new int[n + 1];
        int ans = 0, revCnt = 0;
        for (int i = 0; i < n; ++i) {
            revCnt += diff[i];
            if ((A[i] + revCnt) % 2 == 0) {
                if (i + K > n) {
                    return -1;
                }
                ++ans;
                ++revCnt;
                --diff[i + K];
            }
        }
        return ans;
    }
}
