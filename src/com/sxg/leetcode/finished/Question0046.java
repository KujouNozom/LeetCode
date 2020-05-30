package com.sxg.leetcode.finished;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Question0046
 * @Author: Su_N
 * @Date: 2020/4/28 13:26
 * @Description: 回溯
 * 46. 全排列
 * <p>
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class Question0046 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        List<Integer> remain = new ArrayList<>();
        for (int index = 0; index < nums.length; index++) {
            remain.add(nums[index]);
        }
        function(result, new ArrayList<>(), remain);
        return result;
    }

    private void function(List<List<Integer>> result, List<Integer> current, List<Integer> remain) {
        if (remain.isEmpty()) {
            result.add(current);
        } else {
            for (Integer temp : remain) {
                List<Integer> tempRemain = new ArrayList<>(remain);
                tempRemain.remove(temp);

                List<Integer> tempCurrent = new ArrayList<>(current);
                tempCurrent.add(temp);

                function(result, tempCurrent, tempRemain);
            }
        }
    }
}
