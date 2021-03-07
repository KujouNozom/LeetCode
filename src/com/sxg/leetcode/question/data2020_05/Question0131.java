package com.sxg.leetcode.question.data2020_05;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @ClassName: Question0131
 * @Author: Su_N
 * @Date: 2020/5/31 8:57
 * @Description: 131. 分割回文串 [回溯，动态规划]
 */
public class Question0131 {
    private String data;

    private int length;

    private List<List<String>> result;

    private boolean[][] backStrStatus;

    public List<List<String>> partition(String s) {
        data = s;
        length = s.length();
        result = new ArrayList<>();

        if (length == 0) {
            return result;
        }

        backStrStatus = getBackStrStatus(s, length);

        Deque<String> current = new ArrayDeque<>();
        backtracking(current, 0);
        return result;
    }

    private boolean[][] getBackStrStatus(String s, int len) {
        boolean[][] backStrStatus = new boolean[len][len];

        for (int right = 0; right < len; right++) {
            for (int left = 0; left <= right; left++) {
                if (s.charAt(left) == s.charAt(right)) {
                    // 如果中间是一个或者0个字符，那么只要这两个相等就是回文
                    // 如果中间是多个字符，那么中间的必须是回文，加上这两个才是回文
                    if (right - left <= 2 || backStrStatus[left + 1][right - 1]) {
                        backStrStatus[left][right] = true;
                    }
                }
            }
        }
        return backStrStatus;
    }

    private void backtracking(Deque<String> current, int start) {
        if (start == length) {
            result.add(new ArrayList<>(current));
        } else {
            for (int i = start; i < length; i++) {
                if (backStrStatus[start][i]) {
                    current.addLast(data.substring(start, i + 1));
                    backtracking(current, i + 1);
                    current.removeLast();
                }
            }
        }
    }
}
