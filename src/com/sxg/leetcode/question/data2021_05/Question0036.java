package com.sxg.leetcode.question.data2021_05;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName: Question0036
 * @Author: Su_N
 * @Date: 2020/5/1 10:38
 * @Description: 36. 有效数独
 */
public class Question0036 {
    public static void main(String[] args) {
        Question0036 demo = new Question0036();
        demo.isValidSudoku(new char[][] {{'8', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}});
    }

    public boolean isValidSudoku(char[][] board) {
        if (board == null) {
            return false;
        }

        Map<Integer, Set<Character>> rowMap = new HashMap<>();
        Map<Integer, Set<Character>> colMap = new HashMap<>();
        Map<Integer, Set<Character>> sqrMap = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (!check(rowMap, board[i][j], i))
                        return false;
                    if (!check(colMap, board[i][j], j))
                        return false;
                    if (!check(sqrMap, board[i][j], (i / 3) * 3 + j / 3))
                        return false;
                }

            }
        }

        return true;
    }

    private boolean check(Map<Integer, Set<Character>> valueMap, Character value, int index) {
        Set<Character> valueSet = valueMap.get(index);
        if (valueSet == null) {
            valueSet = new HashSet<>();
            valueSet.add(value);
            valueMap.put(index, valueSet);
        } else {
            if (valueSet.contains(value)) {
                return false;
            } else {
                valueSet.add(value);
            }
        }
        return true;
    }
}
