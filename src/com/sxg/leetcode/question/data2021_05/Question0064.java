package com.sxg.leetcode.question.data2021_05;

/**
 * @ClassName: Question0064
 * @Author: Su_N
 * @Date: 2020/5/12 18:52
 * @Description: 64. 最小路径和 [动态规划]
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
