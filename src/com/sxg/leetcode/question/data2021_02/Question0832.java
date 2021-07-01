package com.sxg.leetcode.question;

/**
 * @ClassName: Question0832
 * @Author: Su_N
 * @Date: 2021/2/24 22:42
 * @Description: 832. 翻转图像
 */
public class Question0832 {
    public int[][] flipAndInvertImage(int[][] A) {
        int rowCount = A.length;
        int colCount = A[0].length;
        int[][] ans = new int[rowCount][colCount];

        for (int row = 0; row < rowCount; row++) {
            for (int index = 0; index < colCount; index++) {
                ans[row][index] = 1 ^ A[row][colCount - index - 1];
            }
        }

        return ans;
    }
}
