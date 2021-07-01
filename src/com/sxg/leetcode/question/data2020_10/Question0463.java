package com.sxg.leetcode.question.data2020_10;

/**
 * @ClassName: Question0463
 * @Author: Su_N
 * @Date: 2020/10/30 20:36
 * @Description: 深度搜索
 * 深搜，1旁边是0的时候加1
 * 463. 岛屿的周长
 *
 * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
 *
 * 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 *
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 *
 *
 *
 * 示例 :
 *
 * 输入:
 * [[0,1,0,0],
 * [1,1,1,0],
 * [0,1,0,0],
 * [1,1,0,0]]
 *
 * 输出: 16
 *
 * 解释: 它的周长是下面图片中的 16 个黄色的边：
 */
public class Question0463 {
    private int[] fwi = new int[]{0, 1, 0, -1};

    private int[] fwj = new int[]{1, 0, -1, 0};

    private int[][] datas;

    private int m;

    private int n;

    private int ans;

    public int islandPerimeter(int[][] grid) {
        this.datas = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        this.ans = 0;

        for (int i = 0; i < m && ans == 0; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    functioin(i, j);
                    break;
                }
            }
        }

        return ans;
    }

    private void functioin(int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            ans++;
            return;
        }

        if (datas[i][j] == 0) {
            ans++;
        } else if (datas[i][j] == 1) {
            datas[i][j] = 2;
            for (int index = 0; index < 4; index++) {
                functioin(i + fwi[index], j + fwj[index]);
            }
        }
    }
}
