package com.sxg.leetcode.question.data2020_0x.no0401_0450;

/**
 * @ClassName: Question0413
 * @Author: Su_N
 * @Date: 2020/8/4 21:53
 * @Description: 排序，找出等差的每一段，这段的长度可以通过公式(currentCount - 1) * (currentCount - 2) / 2;计算出来有多少等差组合
 *
 * 413. 等差数列划分
 *
 * 如果一个数列至少有三个元素，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 *
 * 例如，以下数列为等差数列:
 *
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 *
 * 以下数列不是等差数列。
 *
 * 1, 1, 2, 5, 7
 *
 *
 *
 * 数组 A 包含 N 个数，且索引从0开始。数组 A 的一个子数组划分为数组 (P, Q)，P 与 Q 是整数且满足 0<=P<Q<N 。
 *
 * 如果满足以下条件，则称子数组(P, Q)为等差数组：
 *
 * 元素 A[P], A[p + 1], ..., A[Q - 1], A[Q] 是等差的。并且 P + 1 < Q 。
 *
 * 函数要返回数组 A 中所有为等差数组的子数组个数。
 */
public class Question0413 {
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }

        int currentCount = 2;
        int currentDifference = A[1] - A[0] + 1;
        int answer = 0;

        for (int index = 1; index < A.length; index++) {
            int temp = A[index] - A[index - 1];
            if (currentDifference != temp) {
                if (currentCount >= 3) {
                    answer += (currentCount - 1) * (currentCount - 2) / 2;
                }

                currentCount = 2;
                currentDifference = temp;
            } else {
                currentCount++;
            }
        }

        if (currentCount >= 3) {
            answer += (currentCount - 1) * (currentCount - 2) / 2;
        }

        return answer;
    }
}
