package com.sxg.leetcode.bad;

/**
 * @ClassName: Question0803
 * @Author: Su_N
 * @Date: 2021/1/16 20:44
 * @Description: 803. 打砖块
 *
 * 有一个 m x n 的二元网格，其中 1 表示砖块，0 表示空白。砖块 稳定（不会掉落）的前提是：
 * 一块砖直接连接到网格的顶部，或者
 * 至少有一块相邻（4 个方向之一）砖块 稳定 不会掉落时
 * 给你一个数组 hits ，这是需要依次消除砖块的位置。每当消除 hits[i] = (rowi, coli) 位置上的砖块时，对应位置的砖块（若存在）会消失，然后其他的砖块可能因为这一消除操作而掉落。一旦砖块掉落，它会立即从网格中消失（即，它不会落在其他稳定的砖块上）。
 * 返回一个数组 result ，其中 result[i] 表示第 i 次消除操作对应掉落的砖块数目。
 * 注意，消除可能指向是没有砖块的空白位置，如果发生这种情况，则没有砖块掉落。
 *
 * 示例 1：
 * 输入：grid = [[1,0,0,0],[1,1,1,0]], hits = [[1,0]]
 * 输出：[2]
 * 解释：
 * 网格开始为：
 * [[1,0,0,0]，
 * [1,1,1,0]]
 * 消除 (1,0) 处加粗的砖块，得到网格：
 * [[1,0,0,0]
 * [0,1,1,0]]
 * 两个加粗的砖不再稳定，因为它们不再与顶部相连，也不再与另一个稳定的砖相邻，因此它们将掉落。得到网格：
 * [[1,0,0,0],
 * [0,0,0,0]]
 * 因此，结果为 [2] 。
 *
 * 示例 2：
 * 输入：grid = [[1,0,0,0],[1,1,0,0]], hits = [[1,1],[1,0]]
 * 输出：[0,0]
 * 解释：
 * 网格开始为：
 * [[1,0,0,0],
 * [1,1,0,0]]
 * 消除 (1,1) 处加粗的砖块，得到网格：
 * [[1,0,0,0],
 * [1,0,0,0]]
 * 剩下的砖都很稳定，所以不会掉落。网格保持不变：
 * [[1,0,0,0],
 * [1,0,0,0]]
 * 接下来消除 (1,0) 处加粗的砖块，得到网格：
 * [[1,0,0,0],
 * [0,0,0,0]]
 * 剩下的砖块仍然是稳定的，所以不会有砖块掉落。
 * 因此，结果为 [0,0] 。
 *
 * 提示：
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * grid[i][j] 为 0 或 1
 * 1 <= hits.length <= 4 * 104
 * hits[i].length == 2
 * 0 <= xi <= m - 1
 * 0 <= yi <= n - 1
 * 所有 (xi, yi) 互不相同
 */
public class Question0803 {
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int h = grid.length, w = grid[0].length;

        UnionFind uf = new UnionFind(h * w + 1);
        int[][] status = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                status[i][j] = grid[i][j];
            }
        }
        for (int i = 0; i < hits.length; i++) {
            status[hits[i][0]][hits[i][1]] = 0;
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (status[i][j] == 1) {
                    if (i == 0) {
                        uf.merge(h * w, i * w + j);
                    }
                    if (i > 0 && status[i - 1][j] == 1) {
                        uf.merge(i * w + j, (i - 1) * w + j);
                    }
                    if (j > 0 && status[i][j - 1] == 1) {
                        uf.merge(i * w + j, i * w + j - 1);
                    }
                }
            }
        }
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[] ret = new int[hits.length];
        for (int i = hits.length - 1; i >= 0; i--) {
            int r = hits[i][0], c = hits[i][1];
            if (grid[r][c] == 0) {
                continue;
            }
            int prev = uf.size(h * w);

            if (r == 0) {
                uf.merge(c, h * w);
            }
            for (int[] direction : directions) {
                int dr = direction[0], dc = direction[1];
                int nr = r + dr, nc = c + dc;

                if (nr >= 0 && nr < h && nc >= 0 && nc < w) {
                    if (status[nr][nc] == 1) {
                        uf.merge(r * w + c, nr * w + nc);
                    }
                }
            }
            int size = uf.size(h * w);
            ret[i] = Math.max(0, size - prev - 1);
            status[r][c] = 1;
        }
        return ret;
    }
}

class UnionFind {
    int[] f;

    int[] sz;

    public UnionFind(int n) {
        f = new int[n];
        sz = new int[n];
        for (int i = 0; i < n; i++) {
            f[i] = i;
            sz[i] = 1;
        }
    }

    public int find(int x) {
        if (f[x] == x) {
            return x;
        }
        int newf = find(f[x]);
        f[x] = newf;
        return f[x];
    }

    public void merge(int x, int y) {
        int fx = find(x), fy = find(y);
        if (fx == fy) {
            return;
        }
        f[fx] = fy;
        sz[fy] += sz[fx];
    }

    public int size(int x) {
        return sz[find(x)];
    }
}
