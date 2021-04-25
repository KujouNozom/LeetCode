package com.sxg.leetcode.question;

/**
 * @ClassName: Question0338
 * @Author: Su_N
 * @Date: 2021/3/3 22:34
 * @Description: 338. 比特位计数 [动态规划，位运算]
 */
public class Question0338 {
    public int[] countBits(int num) {
        if (num == 0) {
            return new int[] {0};
        }

        int[] ans = new int[num + 1];
        ans[0] = 0;
        ans[1] = 1;
        int currentBitMaxValue = 1;
        for (int index = 2; index <= num; index++) {
            if ((index & (index - 1)) == 0) {
                currentBitMaxValue = currentBitMaxValue << 1;
            }
            ans[index] = ans[index - currentBitMaxValue] + 1;
        }
        return ans;
    }
}
