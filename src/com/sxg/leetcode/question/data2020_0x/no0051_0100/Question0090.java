package com.sxg.leetcode.question.data2020_0x.no0051_0100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Question0090
 * @Author: Su_N
 * @Date: 2020/5/14 19:10
 * @Description: 排序, 回溯
 * 先对数组排序，然后回溯
 * 注意，这里循环的时候，要判断如果和前一个元素相等，就跳过，因为这样添加的结果是一样的最后会有重复
 * 90. 子集 II
 * <p>
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,2]
 * 输出:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 */
public class Question0090 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return null;
        }

        Arrays.sort(nums);
        function(result, new ArrayList<>(), nums, 0);

        return result;
    }

    private void function(List<List<Integer>> result, List<Integer> current, int[] nums, int index) {
        result.add(current);
        if (index < nums.length) {
            int pre = nums[index] - 1;
            for (; index < nums.length; index++) {
                if (pre == nums[index]) {
                    continue;
                }

                List<Integer> temp = new ArrayList<>();
                temp.addAll(current);
                temp.add(nums[index]);
                function(result, temp, nums, index + 1);
                pre = nums[index];
            }
        }
    }
}
