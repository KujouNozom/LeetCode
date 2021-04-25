package com.sxg.leetcode.question.data2020_0x.no0101_0150;

/**
 * @ClassName: Question0130
 * @Author: Su_N
 * @Date: 2020/5/30 19:29
 * @Description: 深度 广度搜索都可以，从边界查找O的位置，然后该位置所有相邻的位置最终都设置成Y
 * 最后将剩余的 O 替换为 X,将 Y 替换为O
 * <p>
 * 130. 被围绕的区域
 * <p>
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * <p>
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * <p>
 * 示例:
 * <p>
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * <p>
 * 运行你的函数后，矩阵变为：
 * <p>
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * <p>
 * 解释:
 * <p>
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。
 * 如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 */
public class Question0130 {
    private int[] fwi = {0, 1, 0, -1};

    private int[] fwj = {1, 0, -1, 0};

    private int lengthI;

    private int lengthJ;

    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        lengthI = board.length;
        lengthJ = board[0].length;

        for (int i1 = 0, i2 = lengthI - 1, j = 0; j < lengthJ; j++) {
            if (board[i1][j] == 'O') {
                change(board, i1, j);
            }
            if (board[i2][j] == 'O') {
                change(board, i2, j);
            }
        }


        for (int j1 = 0, j2 = lengthJ - 1, i = 1; i < lengthI - 1; i++) {
            if (board[i][j1] == 'O') {
                change(board, i, j1);
            }
            if (board[i][j2] == 'O') {
                change(board, i, j2);
            }
        }

        for (int i = 0; i < lengthI; i++) {
            for (int j = 0; j < lengthJ; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                    continue;
                }

                if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                }
            }
        }

    }

    private void change(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= lengthI || j >= lengthJ) {
            return;
        }

        if (board[i][j] == 'O') {
            board[i][j] = 'Y';
            for (int index = 0; index < 4; index++) {
                change(board, i + fwi[index], j + fwj[index]);
            }
        }
    }
}
