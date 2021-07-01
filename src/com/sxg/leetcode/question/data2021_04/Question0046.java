package com.sxg.leetcode.question.data2021_04;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Question0046
 * @Author: Su_N
 * @Date: 2020/4/28 13:26
 * @Description: 46. 全排列 [回溯]
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
