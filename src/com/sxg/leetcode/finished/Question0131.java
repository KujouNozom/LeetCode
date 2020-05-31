package com.sxg.leetcode.finished;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @ClassName: Question0131
 * @Author: Su_N
 * @Date: 2020/5/31 8:57
 * @Description: 回溯，动态规划
 * 可以使用回溯，剪枝的方法
 * 但是每次都要计算当前子串是不是回文，时间复杂度较高
 * 可以使用求回文子串的动态规划（0005）先求出所有的子串，然后剪枝的时候可以直接判断是不是回文串
 * <p>
 * 131. 分割回文串
 * <p>
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * <p>
 * 返回 s 所有可能的分割方案。
 * <p>
 * 示例:
 * <p>
 * 输入: "aab"
 * 输出:
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
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
