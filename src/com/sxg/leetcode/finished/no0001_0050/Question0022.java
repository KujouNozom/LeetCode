package com.sxg.leetcode.finished.no0001_0050;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Question0022
 * @Author: Su_N
 * @Date: 2020/4/27 22:27
 * @Description: 22. 括号生成
 * <p>
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：n = 3
 * 输出：[
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class Question0022 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n != 0) {
            function(result, "", n, n);
        }

        return result;
    }

    private void function(List<String> result, String current, int leftCount, int rightCount) {
        if (leftCount == 0 && rightCount == 0) {
            result.add(current);
        }

        if (leftCount != 0) {
            function(result, current + "(", leftCount-1, rightCount);
        }

        if (rightCount != 0 && leftCount < rightCount) {
            function(result, current + ")", leftCount, rightCount-1);
        }
    }
}
