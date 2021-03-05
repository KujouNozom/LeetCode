package com.sxg.leetcode.question.data2020_05;

/**
 * @ClassName: Question0063
 * @Author: Su_N
 * @Date: 2020/5/11 19:46
 * @Description: 63. 不同路径 II [类似0062，当(i,j)位置为障碍物的时候，f(i,j) = 0]
 */
public class Question0063 {
    public static void main(String[] args) {
        Question0063 Demo = new Question0063();
        Demo.uniquePathsWithObstacles(new int[][] {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}});
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) {
            return 0;
        }

        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] steps = new int[m][n];
        steps[0][0] = 1;
        for (int index = 1; index < m; index++) {
            if (obstacleGrid[index][0] == 1) {
                steps[index][0] = 0;
            } else {
                steps[index][0] = steps[index - 1][0];
            }
        }

        for (int index = 1; index < n; index++) {
            if (obstacleGrid[0][index] == 1) {
                steps[0][index] = 0;
            } else {
                steps[0][index] = steps[0][index - 1];
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] != 1) {
                    steps[i][j] = steps[i - 1][j] + steps[i][j - 1];
                } else {
                    steps[i][j] = 0;
                }
            }
        }

        return steps[m - 1][n - 1];
    }
}
