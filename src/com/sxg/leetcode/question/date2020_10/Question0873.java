package com.sxg.leetcode.question.date2020_10;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Question0873
 * @Author: Su_N
 * @Date: 2020/10/2 21:16
 * @Description: 动态规划
 * dp[i][j]：表示以 j 结尾的数列长度，通过 A[i] + A[j] 可以推导出数列下一个位置 k（如果存在的话）
 *
 * i = index(A[k] - A[j])
 * i 存在的时候 dp[j][k] = dp[i][j] + 1
 * i 不存在的时候 dp[j][k] = 2
 *
 * 计算过程中每次计算出来的 dp 值，取最大值
 * 注意，结果 <3 的时候返回0，因为斐波那契数列最小需要三个数
 */
public class Question0873 {
    public int lenLongestFibSubseq(int[] A) {
        int length = A.length;
        Map<Integer, Integer> indexes = new HashMap<>(length);

        for (int index = 0; index < length; index++) {
            indexes.put(A[index], index);
        }

        int[][] dp = new int[length][length];
        int max = 0;

        for (int k = 0; k < length; k++) {
            for (int j = 0; j < k; j++) {
                Integer i = indexes.get(A[k] - A[j]);
                if (i != null && i < j) {
                    dp[j][k] = (dp[i][j] == 0 ? 2 : dp[i][j]) + 1;
                    max = Math.max(max, dp[j][k]);
                }
            }
        }

        return max < 3 ? 0 : max;
    }
}
