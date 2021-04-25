package com.sxg.leetcode.question.data2020_04;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Question0022
 * @Author: Su_N
 * @Date: 2020/4/27 22:27
 * @Description: 22. 括号生成
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
            function(result, current + "(", leftCount - 1, rightCount);
        }

        if (rightCount != 0 && leftCount < rightCount) {
            function(result, current + ")", leftCount, rightCount - 1);
        }
    }
}
