package com.sxg.leetcode.question;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Question0448
 * @Author: Su_N
 * @Date: 2021/2/13 21:53
 * @Description: 448. 找到所有数组中消失的数字
 */
public class Question0448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int length = nums.length;
        for (int index = 0; index < length; index++) {
            int value = Math.abs(nums[index]);
            nums[value - 1] = -Math.abs(nums[value - 1]);
        }

        List<Integer> ans = new ArrayList<>();
        for (int index = 0; index < length; index++) {
            if (nums[index] > 0) {
                ans.add(index + 1);
            }
        }

        return ans;
    }
}
