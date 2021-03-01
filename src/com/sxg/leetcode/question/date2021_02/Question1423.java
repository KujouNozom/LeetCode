package com.sxg.leetcode.question;

/**
 * @ClassName: Question1423
 * @Author: Su_N
 * @Date: 2021/2/6 11:24
 * @Description: 1423. 可获得的最大点数 滑动窗口
 */
public class Question1423 {
    public int maxScore(int[] cardPoints, int k) {
        int temp = 0;
        for (int index = 0; index < k; index++) {
            temp += cardPoints[index];
        }

        int length = cardPoints.length;
        int ans = temp;
        for (int index = 0; index < k; index++) {
            temp = temp - cardPoints[k - index - 1] + cardPoints[length - index - 1];
            ans = Math.max(ans, temp);
        }

        return ans;
    }
}
