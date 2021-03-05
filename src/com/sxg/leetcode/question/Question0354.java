package com.sxg.leetcode.question;

import java.util.Arrays;

/**
 * @ClassName: Question0354
 * @Author: Su_N
 * @Date: 2021/3/5 21:37
 * @Description: 354. 俄罗斯套娃信封问题 [动态规划，二分查找]
 */
public class Question0354 {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (e1, e2) -> e1[0] == e2[0] ? e2[1] - e1[1] : e1[0] - e2[0]);

        int length = envelopes.length;
        int ans = 1;
        int dp[] = new int[length];
        dp[0] = 1;
        for (int index = 0; index < length; index++) {
            int temp = 1;
            for (int indexH = 0; indexH < index; indexH++) {
                if (envelopes[indexH][1] < envelopes[index][1]) {
                    temp = Math.max(temp, dp[indexH] + 1);
                }
            }

            dp[index] = temp;
            ans = Math.max(ans, temp);
        }

        return ans;
    }
}
