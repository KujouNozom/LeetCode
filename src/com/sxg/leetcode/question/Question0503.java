package com.sxg.leetcode.question;

import java.util.Arrays;
import java.util.Stack;

/**
 * @ClassName: Question0503
 * @Author: Su_N
 * @Date: 2021/3/6 20:30
 * @Description: 503. 下一个更大元素 II [单调栈]
 */
public class Question0503 {
    public int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[length];
        Arrays.fill(ans, -1);

        for (int temp = 0; temp < length * 2 - 1; temp++) {
            int index = temp % length;
            if (stack.isEmpty() || nums[stack.peek()] >= nums[index]) {
                stack.push(index);
            } else if (nums[stack.peek()] < nums[index]) {
                while (!stack.isEmpty() && nums[stack.peek()] < nums[index]) {
                    ans[stack.pop()] = nums[index];
                }
                stack.push(index);
            }
        }

        return ans;
    }
}
