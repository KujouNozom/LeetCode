package com.sxg.leetcode.question.data2020_0x.no0201_0250;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Question0216
 * @Author: Su_N
 * @Date: 2020/6/28 23:40
 * @Description: 回溯剪枝
 *
 * 216. 组合总和 III
 *
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 *
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 *
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class Question0216 {
    private int n;

    private int k;

    private List<List<Integer>> answers;

    public List<List<Integer>> combinationSum3(int k, int n) {
        this.n = n;
        this.k = k;
        answers = new ArrayList<>();

        if (n == 0 || k == 0) {
            return answers;
        }
        function(new ArrayList<>(), 0, 1);

        return answers;
    }

    private void function(List<Integer> current, int sum, int index) {
        if (sum > n || current.size() > k) {
            return;
        }

        if (current.size() == k && sum == n) {
            List<Integer> answer = new ArrayList<>();
            answer.addAll(current);
            answers.add(answer);
        } else {
            for (; index <= 9; index++) {
                current.add(index);
                function(current, sum + index, index + 1);
                current.remove(current.size() - 1);
            }
        }
    }
}
