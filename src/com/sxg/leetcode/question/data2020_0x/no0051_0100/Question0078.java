package com.sxg.leetcode.question.data2020_0x.no0051_0100;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Question0078
 * @Author: Su_N
 * @Date: 2020/5/12 20:36
 * @Description: 回溯
 * 78. 子集
 * <p>
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */
public class Question0078 {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null) {
            return null;
        }

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        function(result, new ArrayList<Integer>(), nums, 0);

        return result;
    }

    private void function(List<List<Integer>> result, List<Integer> current, int[] nums, int index) {
        result.add(current);

        if (current.size() < nums.length) {
            for (; index < nums.length; index++) {
                List<Integer> temp = new ArrayList<Integer>();
                temp.addAll(current);
                temp.add(nums[index]);
                function(result, temp, nums, index + 1);
            }
        }
    }
}
