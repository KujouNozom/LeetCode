package com.sxg.leetcode.question.data2020_0x.no0201_0250;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Question0228
 * @Author: Su_N
 * @Date: 2020/7/3 22:43
 * @Description: 相差不是1就说明相连两个值不是一个区间，需要使用两个指针保存区间集合
 * 228. 汇总区间
 *
 * 给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。
 *
 * 示例 1:
 *
 * 输入: [0,1,2,4,5,7]
 * 输出: ["0->2","4->5","7"]
 * 解释: 0,1,2 可组成一个连续的区间; 4,5 可组成一个连续的区间。
 *
 * 示例 2:
 *
 * 输入: [0,2,3,4,6,8,9]
 * 输出: ["0","2->4","6","8->9"]
 * 解释: 2,3,4 可组成一个连续的区间; 8,9 可组成一个连续的区间。
 */
public class Question0228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> answer = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return answer;
        }


        int left = 0;
        int pre = nums[0] - 1;
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] - 1 != pre) {
                if (left != index - 1) {
                    answer.add(nums[left] + "->" + (nums[index - 1]));
                } else {
                    answer.add(String.valueOf(nums[left]));
                }

                left = index;
            }
            pre = nums[index];
        }

        if (left == nums.length - 1) {
            answer.add(String.valueOf(nums[nums.length - 1]));
        } else {
            answer.add(nums[left] + "->" + (nums[nums.length - 1]));
        }

        return answer;
    }
}
