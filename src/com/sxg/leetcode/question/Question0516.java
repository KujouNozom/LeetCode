package com.sxg.leetcode.question;

import java.util.Arrays;

/**
 * @ClassName: Question0516
 * @Author: Su_N
 * @Date: 2021/2/16 22:53
 * @Description: 561. 数组拆分 I
 */
public class Question0516 {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int length = nums.length;
        for (int index = 0; index < length; index += 2) {
            ans += nums[index];
        }
        return ans;
    }
}
