package com.sxg.leetcode.question.data2020_04;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Question0039
 * @Author: Su_N
 * @Date: 2020/4/28 12:41
 * @Description: 39. 组合总和 [回溯]
 */
public class Question0039 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        function(result, new ArrayList<>(), target, candidates, 0);
        return result;
    }

    private void function(List<List<Integer>> result, List<Integer> current, int target, int[] candidates, int index) {
        if (target == 0) {
            result.add(current);
        }

        for (; index < candidates.length; index++) {
            if (candidates[index] <= target) {
                List<Integer> currentTemp = new ArrayList<>();
                currentTemp.addAll(current);
                currentTemp.add(candidates[index]);
                function(result, currentTemp, target - candidates[index], candidates, index);
            }
        }

    }
}
