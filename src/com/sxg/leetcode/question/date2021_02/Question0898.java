package com.sxg.leetcode.question;

/**
 * @ClassName: Question0898
 * @Author: Su_N
 * @Date: 2021/3/1 23:25
 * @Description: 896.单调数列
 */
public class Question0898 {
    public boolean isMonotonic(int[] A) {
        if (A.length == 1 || A.length == 2) {
            return true;
        }

        int length = A.length;
        boolean addFlag = false;
        boolean incFlag = false;
        for (int index = 0; index < length - 1; index++) {
            int temp = A[index + 1] - A[index];
            if (temp < 0) {
                incFlag = true;
                if (addFlag) {
                    return false;
                }
            } else if (temp > 0) {
                addFlag = true;
                if (incFlag) {
                    return false;
                }
            }
        }
        return true;
    }
}
