package com.sxg.leetcode.question;

/**
 * @ClassName: LCP02
 * @Author: Su_N
 * @Date: 2021/2/22 22:57
 * @Description: LCP 02. 分式化简
 */
public class LCP02 {
    public int[] fraction(int[] cont) {
        int length = cont.length;
        int numerator = 1;
        int denominator = cont[length - 1];

        for (int index = length - 2; index >= 0; index--) {
            int temp = denominator;
            denominator = temp * cont[index] + numerator;
            numerator = temp;
        }

        return new int[]{denominator, numerator};
    }
}
