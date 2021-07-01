package com.sxg.leetcode.question;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: Question0888
 * @Author: Su_N
 * @Date: 2021/2/1 23:52
 * @Description: 888. 公平的糖果棒交换
 */
public class Question0888 {
    public int[] fairCandySwap(int[] A, int[] B) {
        Set<Integer> setB = new HashSet<>(B.length);
        int dValue = 0;
        int lengthA = A.length;
        int lengthB = B.length;
        for (int index = 0; index < lengthA; index++) {
            dValue += A[index];
        }

        for (int index = 0; index < lengthB; index++) {
            dValue -= B[index];
            setB.add(B[index]);
        }

        int target = dValue / 2;
        int[] ans = new int[2];
        for (int index = 0; index < lengthA; index++) {
            if (setB.contains(A[index] - target)) {
                ans = new int[] {A[index], A[index] - target};
            }
        }

        return ans;
    }
}
