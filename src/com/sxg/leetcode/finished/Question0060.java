package com.sxg.leetcode.finished;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName: Question0060
 * @Author: Su_N
 * @Date: 2020/5/9 18:50
 * @Description: n位可以表示的数是n!个，n+1位每+1，则可以多表示n!个数，可以直接推算第k位数的每一位
 * <p>
 * 60. 第k个排列
 * <p>
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * <p>
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * <p>
 * 给定 n 和 k，返回第 k 个排列。
 * <p>
 * 说明：
 * <p>
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 3, k = 3
 * 输出: "213"
 * <p>
 * 示例 2:
 * <p>
 * 输入: n = 4, k = 9
 * 输出: "2314"
 */
public class Question0060 {
    public String getPermutation(int n, int k) {
        if (n == 0) {
            return null;
        }

        if (n == 1) {
            return String.valueOf(n);
        }

        List<Integer> nums = new ArrayList<>();
        List<Integer> factorials = new ArrayList<>();

        int tempFactorial = 1;
        for (int index = 1; index <= n; index++) {
            nums.add(index);
            tempFactorial = tempFactorial * index;
            factorials.add(tempFactorial);
        }

        StringBuilder result = new StringBuilder();
        int count = 1;
        while (k != 0) {
            int factorial = factorials.get(n - 1 - count);
            int index = (k - 1) / factorial;
            result.append(nums.get(index));
            nums.remove(index);

            count++;
            k = k % factorial;
        }

        Collections.reverse(nums);
        for (int temp : nums) {
            result.append(temp);
        }

        return result.toString();
    }
}
