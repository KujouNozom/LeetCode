package com.sxg.leetcode.question.data2021_04;

/**
 * @ClassName: Question0829
 * @Author: Su_N
 * @Date: 2021/3/5 21:44
 * @Description: 829. 连续整数求和 [数学方法]
 */
public class Question0829 {
    public int consecutiveNumbersSum(int N) {
        int ans = 0;
        int max = (int)Math.sqrt(2 * N);
        for (int k = 1; k <= max; k++) {
            if (2 * N % k == 0) {
                int y = 2 * N / k - k - 1;
                if (y % 2 == 0 && y >= 0)
                    ans++;
            }
        }

        return ans;
    }
}
