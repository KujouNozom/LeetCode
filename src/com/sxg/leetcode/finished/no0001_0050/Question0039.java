package com.sxg.leetcode.finished.no0001_0050;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Question0039
 * @Author: Su_N
 * @Date: 2020/4/28 12:41
 * @Description: 回溯
 * 39. 组合总和
 * <p>
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * <p>
 * 示例 1:
 * <p>
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * [7],
 * [2,2,3]
 * ]
 * <p>
 * 示例 2:
 * <p>
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
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
