package com.sxg.leetcode.question.data2020_0x.no0201_0250;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Question0229
 * @Author: Su_N
 * @Date: 2020/6/29 23:19
 * @Description: 摩尔投票法（两两抵消）
 * 升级摩尔投票法，每当元素够三种不同的时候，相互抵消，不够遇到重复的时候计数累加
 *
 * 229. 求众数 II
 *
 * 给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 *
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: [3]
 *
 * 示例 2:
 *
 * 输入: [1,1,1,3,3,2,2,2]
 * 输出: [1,2]
 */
public class Question0229 {

    public static void main(String[] args) {
        Question0229 demo = new Question0229();
        demo.majorityElement(new int[]{1, 1, 1, 3, 3, 2, 2, 2});
    }

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> answer = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return answer;
        }

        int count1 = 0;
        int target1 = nums[0];
        int count2 = 0;
        int target2 = nums[0];

        for (int temp : nums) {
            if (temp != target1 && temp != target2) {
                if (count1 == 0) {
                    target1 = temp;
                    count1 = 1;
                    continue;
                }

                if (count2 == 0) {
                    target2 = temp;
                    count2 = 1;
                    continue;
                }
                count1--;
                count2--;
                continue;
            }


            if (temp == target1) {
                count1++;
                continue;
            }

            if (temp == target2) {
                count2++;
                continue;
            }

        }

        count1 = 0;
        count2 = 0;

        for (int temp : nums) {
            if (temp == target1) {
                count1++;
            }
            if (temp == target2) {
                count2++;
            }
        }

        if (count1 > nums.length / 3) {
            answer.add(target1);
        }

        if (count2 > nums.length / 3 && target1 != target2) {
            answer.add(target2);
        }

        return answer;
    }
}
