package com.sxg.leetcode.question.data2021_05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName: Question0060
 * @Author: Su_N
 * @Date: 2020/5/9 18:50
 * @Description: 60. 第k个排列 [n位可以表示的数是n!个，n+1位每+1，则可以多表示n!个数，可以直接推算第k位数的每一位]
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
