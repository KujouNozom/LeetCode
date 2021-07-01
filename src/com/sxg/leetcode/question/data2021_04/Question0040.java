package com.sxg.leetcode.question.data2021_04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Question0040
 * @Author: Su_N
 * @Date: 2020/4/28 12:48
 * @Description: 40. 组合总和 II [回溯]
 */
public class Question0040 {
    public static void main(String[] args) {
        int[] nums = {2, 5, 2, 1, 2};
        Question0040 demo = new Question0040();
        System.out.println(demo.combinationSum2(nums, 5));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);

        function(result, new ArrayList<>(), target, candidates, 0);
        return result;
    }

    private void function(List<List<Integer>> result, List<Integer> current, int target, int[] candidates, int index) {
        if (target == 0) {
            result.add(current);
            return;
        }

        if (index >= candidates.length) {
            return;
        }

        int pre = candidates[index] - 1;

        for (; index < candidates.length; index++) {
            if (pre != candidates[index]) {
                if (candidates[index] <= target) {
                    List<Integer> currentTemp = new ArrayList<>();
                    currentTemp.addAll(current);
                    currentTemp.add(candidates[index]);
                    function(result, currentTemp, target - candidates[index], candidates, index + 1);
                }
            }
            pre = candidates[index];
        }
    }
}
