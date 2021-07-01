package com.sxg.leetcode.question.data2020_10;

/**
 * @ClassName: Question0794
 * @Author: Su_N
 * @Date: 2020/10/19 22:32
 * @Description: 分类
 * 分类讨论，X先走，O后走，所以肯定只有两种数量的棋子，X比O多一个，或者一样。
 * 当X比O多一个的时候，最后是X走，所以两种情况，X赢O输或者XO都没赢，共同点是O没赢，判断O赢了的话，就不符合
 * 同理求出两个数量相等的情况
 */
public class Question0794 {
    private int xCount = 0;

    private int oCount = 0;

    public boolean validTicTacToe(String[] board) {
        buildCount(board);
        if (xCount - oCount == 1 || xCount == oCount) {
            if (xCount - oCount == 1) {
                return !isSucceed('O', board);
            }
            if (xCount == oCount) {
                return !isSucceed('X', board);
            }
        }
        return false;
    }

    private boolean isSucceed(char target, String[] board) {
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == target && board[i].charAt(1) == target && board[i].charAt(2) == target) {
                return true;
            }
            if (board[0].charAt(i) == target && board[1].charAt(i) == target && board[2].charAt(i) == target) {
                return true;
            }
        }

        return (board[0].charAt(0) == target && board[1].charAt(1) == target && board[2].charAt(2) == target) || (
                board[0].charAt(2) == target && board[1].charAt(1) == target && board[2].charAt(0) == target);
    }

    private void buildCount(String[] board) {
        for (String row : board) {
            for (char col : row.toCharArray()) {
                if (col == 'X') {
                    xCount++;
                    continue;
                }
                if (col == 'O') {
                    oCount++;
                }
            }
        }
    }
}
