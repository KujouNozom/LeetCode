package com.sxg.leetcode.question.data2020_0x.no0051_0100;

import java.util.Arrays;

/**
 * @ClassName: Question0079
 * @Author: Su_N
 * @Date: 2020/5/14 18:23
 * @Description: 回溯法, 剪枝
 * 79. 单词搜索
 * <p>
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 */
public class Question0079 {
    private int[] fwi = {0, 1, 0, -1};

    private int[] fwj = {1, 0, -1, 0};

    private int m = 0;

    private int n = 0;

    private char[] words;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        words = word.toCharArray();

        for (int starti = 0; starti < m; starti++) {
            for (int startj = 0; startj < n; startj++) {
                boolean[][] allowed = new boolean[m][n];

                if (function(allowed, starti, startj - 1, 0, board)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean function(boolean[][] allowed, int i, int j, int target, char[][] board) {
        if (target == words.length) {
            return true;
        }
        char targetChar = words[target];

        boolean flag = false;
        for (int index = 0; index < 4; index++) {

            int tempi = i + fwi[index];
            int tempj = j + fwj[index];
            if (tempi < 0 || tempi >= m || tempj < 0 || tempj >= n) {
                continue;
            }

            if (allowed[tempi][tempj]) {
                continue;
            }

            if (board[tempi][tempj] == targetChar) {
                boolean[][] allowedTemp = new boolean[m][n];
                for (int copyIndex = 0; copyIndex < m; copyIndex++) {
                    allowedTemp[copyIndex] = Arrays.copyOf(allowed[copyIndex], n);
                }
                allowedTemp[tempi][tempj] = true;

                flag = function(allowedTemp, tempi, tempj, target + 1, board);
                if (flag == true) {
                    break;
                }
            }
        }
        return flag;
    }
}
