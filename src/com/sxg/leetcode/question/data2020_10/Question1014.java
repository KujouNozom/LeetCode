package com.sxg.leetcode.question.data2020_10;

/**
 * @ClassName: Question1014
 * @Author: Su_N
 * @Date: 2020/10/29 22:17
 * @Description: 动态规划
 * A[i] + A[j] + i - j 可以承重组为 (A[i] + i) + (A[j] - j)
 * 我们一边遍历，一边统计当前最大的 A[i] + i，然后使用最大的 A[i] + i 带入到(A[i] + i) + (A[j] - j)，同时统计当前结果最大值
 * 1014. 最佳观光组合
 *
 * 给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。
 *
 * 一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。
 *
 * 返回一对观光景点能取得的最高分。
 *
 *
 *
 * 示例：
 *
 * 输入：[8,1,5,2,6]
 * 输出：11
 * 解释：i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11
 *
 *
 *
 * 提示：
 *
 * 2 <= A.length <= 50000
 * 1 <= A[i] <= 1000
 */
public class Question1014 {
    public int maxScoreSightseeingPair(int[] A) {
        int max = -1;
        int maxi = A[0] + 0;

        for (int index = 1; index < A.length; index++) {
            max = Math.max(max, A[index] - index + maxi);
            maxi = Math.max(maxi, A[index] + index);
        }

        return max;
    }
}
