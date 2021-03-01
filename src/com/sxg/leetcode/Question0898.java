package com.sxg.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: Question0898
 * @Author: Su_N
 * @Date: 2021/3/1 23:41
 * @Description: 898. 子数组按位或操作
 */
public class Question0898 {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> ans = new HashSet<>();
        Set<Integer> currents = new HashSet<>();
        int length = arr.length;
        for (int index = 0; index < length; index++) {
            Set<Integer> temps = new HashSet<>(32 + 1);
            int currentValue = arr[index];
            temps.add(currentValue);
            for (int preAns : currents) {
                temps.add(preAns | currentValue);
            }

            ans.addAll(temps);
            currents = temps;
        }
        return ans.size();
    }
}
