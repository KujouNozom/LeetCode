package com.sxg.leetcode.question.date2020_10;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: Question0051
 * @Author: Su_N
 * @Date: 2020/10/17 12:58
 * @Description: 51. N 皇后 [回溯]
 */
public class Question0051 {
    private int powN;

    private int n;

    private List<List<Integer>> tempAnswers;

    public List<List<String>> solveNQueens(int n) {
        this.tempAnswers = new LinkedList<>();
        this.n = n;
        this.powN = (1 << n) - 1;
        function(0, 0, 0, 0, new LinkedList<>());

        List<List<String>> answers = new LinkedList<>();
        for (int index = 0; index < tempAnswers.size(); index++) {
            List<Integer> tempAnswer = tempAnswers.get(index);
            List<String> answer = new LinkedList<>();
            for (int col : tempAnswer) {
                char[] row = new char[n];
                Arrays.fill(row, '.');
                row[col] = 'Q';
                answer.add(new String(row));
            }
            answers.add(answer);
        }

        return answers;
    }

    private void function(int row, int col, int oblique1, int oblique2, List<Integer> tempAnswer) {
        if (row == n) {
            List<Integer> tempAnswerCopy = new LinkedList<>();
            tempAnswerCopy.addAll(tempAnswer);
            tempAnswers.add(tempAnswerCopy);
        } else {
            int temp = this.powN & (~(col | oblique1 | oblique2));
            while (temp != 0) {
                int flag = temp & (-temp);
                String ansString = Integer.toBinaryString(flag | (powN + 1)).substring(1);
                tempAnswer.add(ansString.indexOf('1'));
                function(row + 1, col | flag, (oblique1 | flag) << 1, (oblique2 | flag) >> 1, tempAnswer);
                temp = temp & (temp - 1);
                tempAnswer.remove(tempAnswer.size() - 1);
            }
        }
    }
}
