package com.sxg.leetcode.question.data2020_10;

/**
 * @ClassName: Question0977
 * @Author: Su_N
 * @Date: 2020/10/16 19:37
 * @Description: 977. 有序数组的平方
 *
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 *
 * 示例 2：
 *
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A 已按非递减顺序排序。
 */
public class Question0977 {
    public int[] sortedSquares(int[] A) {
        int flag = 0;
        for (; flag < A.length; flag++) {
            if (A[flag] >= 0) {
                break;
            }
        }

        int index1 = flag;
        int index2 = flag - 1;
        int[] ans = new int[A.length];
        int count = 0;

        while (index1 < A.length && index2 >= 0) {
            if (A[index1] < -A[index2]) {
                ans[count++] = A[index1] * A[index1];
                index1++;
            } else {
                ans[count++] = A[index2] * A[index2];
                index2--;
            }
        }

        while (index1 < A.length) {
            ans[count++] = A[index1] * A[index1];
            index1++;
        }

        while (index2 >= 0) {
            ans[count++] = A[index2] * A[index2];
            index2--;
        }
        return ans;
    }
}
