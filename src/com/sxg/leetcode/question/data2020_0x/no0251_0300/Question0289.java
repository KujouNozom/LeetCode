package com.sxg.leetcode.question.data2020_0x.no0251_0300;

/**
 * @ClassName: Question0289
 * @Author: Su_N
 * @Date: 2020/7/13 22:40
 * @Description: 使用未使用过的标识为定义新的状态，然后更新
 *
 * 根据 百度百科 ，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
 *
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态：1 即为活细胞（live），或 0 即为死细胞（dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 *
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 *
 * 根据当前状态，写一个函数来计算面板上所有细胞的下一个（一次更新后的）状态。下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
 *
 *
 *
 * 示例：
 *
 * 输入：
 * [
 * [0,1,0],
 * [0,0,1],
 * [1,1,1],
 * [0,0,0]
 * ]
 * 输出：
 * [
 * [0,0,0],
 * [1,0,1],
 * [0,1,1],
 * [0,1,0]
 * ]
 *
 *
 *
 * 进阶：
 *
 * 你可以使用原地算法解决本题吗？请注意，面板上所有格子需要同时被更新：你不能先更新某些格子，然后使用它们的更新后的值再更新其他格子。
 * 本题中，我们使用二维数组来表示面板。原则上，面板是无限的，但当活细胞侵占了面板边界时会造成问题。你将如何解决这些问题？
 */
public class Question0289 {
    private static final int DEAD = 0;

    private static final int LIVE = 1;

    private static final int LIVE_TO_DEAD = 2;

    private static final int DEAD_TO_LIVE = 3;

    private static final int fwi[] = {0, 1, 0, -1, -1, 1, 1, -1};

    private static final int fwj[] = {1, 0, -1, 0, 1, 1, -1, -1};

    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveCount = getLiveCount(board, m, n, i, j);
                refreshStatus(board[i], j, liveCount);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == LIVE_TO_DEAD) {
                    board[i][j] = DEAD;
                    continue;
                }

                if (board[i][j] == DEAD_TO_LIVE) {
                    board[i][j] = LIVE;
                    continue;
                }
            }
        }
    }

    private void refreshStatus(int[] ints, int j, int liveCount) {
        if (ints[j] == LIVE) {
            if (liveCount < 2) {
                ints[j] = LIVE_TO_DEAD;
                return;
            }

            if (liveCount > 3) {
                ints[j] = LIVE_TO_DEAD;
                return;
            }
        } else {
            if (liveCount == 3) {
                ints[j] = DEAD_TO_LIVE;
                return;
            }
        }
    }

    private int getLiveCount(int[][] board, int m, int n, int i, int j) {
        int liveCount = 0;
        for (int index = 0; index < 8; index++) {
            int tempi = i + fwi[index];
            int tempj = j + fwj[index];
            if (tempi >= 0 && tempi < m && tempj >= 0 && tempj < n) {
                if (board[tempi][tempj] == LIVE || board[tempi][tempj] == LIVE_TO_DEAD) {
                    liveCount++;
                }
            }
        }
        return liveCount;
    }
}
