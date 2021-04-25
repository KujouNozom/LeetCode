package com.sxg.leetcode.question.data2020_04;

/**
 * @ClassName: Question0062
 * @Author: Su_N
 * @Date: 2020/5/10 10:02
 * @Description: 动态规划
 * 对于位置(i,j)来说，能够到达他的位置有两个(i-1,j)和(i,j-1)
 * 因此到达(i,j)的方式有f(i,j) = f(i-1,j) + f(i,j-1) (i>=1,j>=1)
 * f(0,n) = 1，f(n,0) = 1.可以通过状态转移方程推断出后面的数值
 * <p>
 * 62. 不同路径
 * <p>
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 问总共有多少条不同的路径？
 * <p>
 * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * <p>
 * 示例 2:
 * <p>
 * 输入: m = 7, n = 3
 * 输出: 28
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= m, n <= 100
 * 题目数据保证答案小于等于 2 * 10 ^ 9
 */
public class Question0062 {
    public int uniquePaths(int m, int n) {
        if (n == 0) {
            return 0;
        }

        int[][] setps = new int[n][m];
        for (int index = 0; index < m; index++) {
            setps[0][index] = 1;
        }
        for (int index = 0; index < n; index++) {
            setps[index][0] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                setps[i][j] = setps[i - 1][j] + setps[i][j - 1];
            }
        }

        return setps[n - 1][m - 1];
    }
}
