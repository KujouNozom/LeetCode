package com.sxg.leetcode.question.data2020_10;

/**
 * @ClassName: com.sxg.leetcode.question.date2020_10.Question1254
 * @Author: Su_N
 * @Date: 2020/10/18 10:46
 * @Description: 深搜
 * 遇到一个的岛屿的时候
 * 1254. 统计封闭岛屿的数目
 *
 * 有一个二维矩阵 grid ，每个位置要么是陆地（记号为 0 ）要么是水域（记号为 1 ）。
 *
 * 我们从一块陆地出发，每次可以往上下左右 4 个方向相邻区域走，能走到的所有陆地区域，我们将其称为一座「岛屿」。
 *
 * 如果一座岛屿 完全 由水域包围，即陆地边缘上下左右所有相邻区域都是水域，那么我们将其称为 「封闭岛屿」。
 *
 * 请返回封闭岛屿的数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
 * 输出：2
 * 解释：
 * 灰色区域的岛屿是封闭岛屿，因为这座岛屿完全被水域包围（即被 1 区域包围）。
 *
 * 示例 2：
 *
 * 输入：grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
 * 输出：1
 *
 * 示例 3：
 *
 * 输入：grid = [[1,1,1,1,1,1,1],
 * [1,0,0,0,0,0,1],
 * [1,0,1,1,1,0,1],
 * [1,0,1,0,1,0,1],
 * [1,0,1,1,1,0,1],
 * [1,0,0,0,0,0,1],
 * [1,1,1,1,1,1,1]]
 * 输出：2
 *
 *
 *
 * 提示：
 *
 * 1 <= grid.length, grid[0].length <= 100
 * 0 <= grid[i][j] <=1
 */
public class Question1254 {
    public static void main(String[] args) {
        new Question1254().closedIsland(new int[][]{{1, 1, 1}, {1, 0, 1}, {0, 1, 0}});
    }

    private int[] fwi = new int[]{0, 1, 0, -1};

    private int[] fwj = new int[]{1, 0, -1, 0};

    private int m;

    private int n;


    public int closedIsland(int[][] grid) {
        int ans = 0;
        m = grid.length;
        n = grid[0].length;


        for (int index = 0; index < n; index++) {
            function(0, index, grid);
            function(m - 1, index, grid);
        }

        for (int index = 0; index < m; index++) {
            function(index, 0, grid);
            function(index - 1, n - 1, grid);
        }

        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 0) {
                    function(i, j, grid);
                    ans++;
                }
            }
        }

        return ans;
    }

    private void function(int i, int j, int[][] grid) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }

        if (grid[i][j] == 0) {
            grid[i][j] = 1;
            for (int index = 0; index < 4; index++) {
                function(i + fwi[index], j + fwj[index], grid);
            }
        }
    }
}