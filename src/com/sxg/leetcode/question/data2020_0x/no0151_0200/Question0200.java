package com.sxg.leetcode.question.data2020_0x.no0151_0200;

/**
 * @ClassName: Question0200
 * @Author: Su_N
 * @Date: 2020/6/20 20:37
 * @Description: 并查集
 * 遍历第一遍，每个节点如果是1，就把它的父节点设置为自己，同时记录1节点的数量
 * 遍历二遍，如果一个节点是1，就修改父节点，把他链接到周围是1的节点上面
 *
 *
 * 200. 岛屿数量
 *
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 *
 *
 * 示例 1:
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 *
 * 示例 2:
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 输出: 3
 * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 */
public class Question0200 {
    private int[] parent;

    private int m;

    private int n;

    private int count;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        m = grid.length;
        n = grid[0].length;
        count = 0;
        parent = new int[m * n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    parent[i * n + j] = i * n + j;
                    count++;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                        union(i * n + j, (i - 1) * n + j);
                    }
                    if (i + 1 < m && grid[i + 1][j] == '1') {
                        union(i * n + j, (i + 1) * n + j);
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                        union(i * n + j, i * n + j - 1);
                    }
                    if (j + 1 < n && grid[i][j + 1] == '1') {
                        union(i * n + j, i * n + j + 1);
                    }
                }
            }
        }


        return count;
    }

    private int find(int index) {
        int currentIndex = index;
        while (parent[currentIndex] != currentIndex) {
            currentIndex = parent[currentIndex];
        }

        return currentIndex;
    }

    private void union(int index1, int index2) {
        int parentIndex1 = find(index1);
        int parentIndex2 = find(index2);

        if (parentIndex1 != parentIndex2) {
            parent[parentIndex1] = parentIndex2;
            count--;
        }
    }
}
