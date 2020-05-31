package com.sxg.leetcode.finished.no0001_0050;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Question0040
 * @Author: Su_N
 * @Date: 2020/4/28 12:48
 * @Description: 回溯
 * 40. 组合总和 II
 * <p>
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 * <p>
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * <p>
 * 示例 2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 * [1,2,2],
 * [5]
 * ]
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
