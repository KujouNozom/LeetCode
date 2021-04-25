package com.sxg.leetcode.question.data2020_0x.no0401_0450;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Question0442
 * @Author: Su_N
 * @Date: 2020/8/11 20:40
 * @Description: 442. 数组中重复的数据
 *
 * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
 *
 * 找到所有出现两次的元素。
 *
 * 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
 *
 * 示例：
 *
 * 输入:
 * [4,3,2,7,8,2,3,1]
 *
 * 输出:
 * [2,3]
 */
public class Question0442 {
    public List<Integer> findDuplicates(int[] nums) {
        if (nums == null || nums.length < 2) {
            return new ArrayList<>();
        }

        List<Integer> answers = new ArrayList<>();

        for (int index = 0; index < nums.length; index++) {
            int value = Math.abs(nums[index]);
            if (nums[value - 1] < 0) {
                answers.add(value);
            } else {
                nums[value - 1] = -nums[value - 1];
            }
        }

        return answers;
    }
}
