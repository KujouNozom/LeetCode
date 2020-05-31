package com.sxg.leetcode.finished.no0051_0100;

/**
 * @ClassName: Question0063
 * @Author: Su_N
 * @Date: 2020/5/11 19:46
 * @Description: 类似0062，当(i,j)位置为障碍物的时候，f(i,j) = 0
 * 63. 不同路径 II
 * <p>
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * <p>
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * <p>
 * 说明：m 和 n 的值均不超过 100。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 */
public class Question0063 {
    public static void main(String[] args) {
        Question0063 Demo = new Question0063();
        Demo.uniquePathsWithObstacles(new int[][]{{0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}});
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
