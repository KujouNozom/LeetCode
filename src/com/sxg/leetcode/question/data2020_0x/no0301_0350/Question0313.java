package com.sxg.leetcode.question.data2020_0x.no0301_0350;

/**
 * @ClassName: Question0313
 * @Author: Su_N
 * @Date: 2020/7/18 22:14
 * @Description: 类似264丑数
 * answer保存丑数集合
 * 使用一个数组 indexes[primes.length] 存储 primes 中的素数将要和 answer 中的那个数相乘
 * 每次遍历 primes 和 indexes 获取每个素数和 answer 中对应位置的丑数的乘积，取最小的几个结果（可能有多个结果） indexex 后移
 *
 * 313. 超级丑数
 *
 * 编写一段程序来查找第 n 个超级丑数。
 *
 * 超级丑数是指其所有质因数都是长度为 k 的质数列表 primes 中的正整数。
 *
 * 示例:
 *
 * 输入: n = 12, primes = [2,7,13,19]
 * 输出: 32
 * 解释: 给定长度为 4 的质数列表 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,28,32] 。
 *
 * 说明:
 *
 * 1 是任何给定 primes 的超级丑数。
 * 给定 primes 中的数字以升序排列。
 * 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000 。
 * 第 n 个超级丑数确保在 32 位有符整数范围内。
 */
public class Question0313 {
    public static void main(String[] args) {
        Question0313 demo = new Question0313();
        demo.nthSuperUglyNumber(12, new int[]{2, 7, 13, 19});
    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n == 0 || primes == null || primes.length == 0) {
            return 0;
        }

        int[] indexes = new int[primes.length];

        int[] answer = new int[n];
        answer[0] = 1;

        for (int answerIndex = 1; answerIndex < n; answerIndex++) {
            int min = Integer.MAX_VALUE;

            for (int index = 0; index < primes.length; index++) {
                min = Math.min(min, primes[index] * answer[indexes[index]]);
            }

            for (int temp = 0; temp < primes.length; temp++) {
                if (primes[temp] * answer[indexes[temp]] == min) {
                    indexes[temp] = indexes[temp] + 1;
                }
            }

            answer[answerIndex] = min;
        }

        return answer[n - 1];
    }
}
