package com.sxg.leetcode.question.data2020_0x.no0051_0100;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Question0077
 * @Author: Su_N
 * @Date: 2020/5/12 20:19
 * @Description: 回溯
 * 后记：这个题使用回溯比较慢，因为使用了大量的递归，递归调用栈费时，处理递归需要时间。可以使用字典序的方式
 * <p>
 * 77. 组合
 * <p>
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */
public class Question0077 {

    //下面的方式是使用回溯，比较慢
    public List<List<Integer>> combine(int n, int k) {
        if (k > n) {
            return null;
        }

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        function(result, new ArrayList<Integer>(), n, k, 1);

        return result;
    }

    private void function(List<List<Integer>> result, List<Integer> current, int n, int k, int index) {
        if (current.size() == k) {
            result.add(current);
        } else {
            for (; index <= n; index++) {
                List<Integer> temp = new ArrayList<Integer>();
                temp.addAll(current);
                temp.add(index);
                function(result, temp, n, k, index + 1);
            }
        }
    }

}
