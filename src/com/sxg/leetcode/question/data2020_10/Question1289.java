package com.sxg.leetcode.question.data2020_10;

import java.util.Arrays;

/**
 * @ClassName: Question1289
 * @Author: Su_N
 * @Date: 2020/10/28 20:49
 * @Description: 动态规划
 * dp[i][j] = data[i][j] + min(dp[i-1,k]) (0 < k < arr[0].length,k != j)
 * 优化：我们不需要记录所有的值，我们只需要记录最小的两个值，因为 min(dp[i-1,k] k!=j，所以最小的两个值，肯定有一个是可选的
 * 此外还需要记录最小值的索引，当索引不同的时候使用最小值，相同的时候使用次小值
 *
 * 1289. 下降路径最小和  II
 *
 * 给你一个整数方阵 arr ，定义「非零偏移下降路径」为：从 arr 数组中的每一行选择一个数字，且按顺序选出来的数字中，相邻数字不在原数组的同一列。
 *
 * 请你返回非零偏移下降路径数字和的最小值。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：13
 * 解释：
 * 所有非零偏移下降路径包括：
 * [1,5,9], [1,5,7], [1,6,7], [1,6,8],
 * [2,4,8], [2,4,9], [2,6,7], [2,6,8],
 * [3,4,8], [3,4,9], [3,5,7], [3,5,9]
 * 下降路径中数字和最小的是 [1,5,7] ，所以答案是 13 。
 *
 *
 *
 * 提示：
 *
 * 1 <= arr.length == arr[i].length <= 200
 * -99 <= arr[i][j] <= 99
 */
public class Question1289 {
    public int minFallingPathSum(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;

        int minIndex = -1;
        int[] mins = new int[2];

        for (int row = 0; row < m; row++) {
            int tempMinIndex = -1;
            int[] tempMins = new int[2];
            Arrays.fill(tempMins, Integer.MAX_VALUE);
            for (int col = 0; col < n; col++) {
                int value;
                if (col != minIndex) {
                    value = arr[row][col] + mins[0];
                } else {
                    value = arr[row][col] + mins[1];
                }

                if (value < tempMins[0]) {
                    tempMins[1] = tempMins[0];
                    tempMins[0] = value;
                    tempMinIndex = col;
                } else if (value < tempMins[1]) {
                    tempMins[1] = value;
                }
            }
            mins = tempMins;
            minIndex = tempMinIndex;
        }

        return mins[0];
    }
}
