package com.sxg.leetcode.finished.no0051_0100;

/**
 * @ClassName: Question0064
 * @Author: Su_N
 * @Date: 2020/5/12 18:52
 * @Description: 动态规划
 * 类似0062，f(i，j)的值等于min(f(i-1,j),f(i,j-1)) + data(i,j)
 * 64. 最小路径和
 * <p>
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 */
public class Question0064 {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        for (int index = 1; index < m; index++) {
            grid[index][0] = grid[index - 1][0] + grid[index][0];
        }
        for (int index = 1; index < n; index++) {
            grid[0][index] = grid[0][index] + grid[0][index - 1];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }

        return grid[m - 1][n - 1];
    }
}
