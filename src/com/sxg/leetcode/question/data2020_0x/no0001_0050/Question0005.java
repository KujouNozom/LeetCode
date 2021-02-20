package com.sxg.leetcode.question.data2020_0x.no0001_0050;

import java.util.Scanner;

/**
 * @ClassName: Question0005
 * @Author: Su_N
 * @Date: 2020/4/26 22:58
 * @Description: 动态规划
 * 5. 最长回文子串
 * <p>
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * <p>
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class Question0005 {
    public static void main(String[] args) {
        Question0005 demo = new Question0005();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            System.out.println(demo.longestPalindrome(scanner.nextLine()));
        }
        scanner.close();
    }


    /**
     * 动态规划，使用状态转换方程
     * f(i,j) = {
     * if( f(i+1,j-1) == 0 || data(i) != data(j)){
     * return 0
     * }else{
     * f(i,j) = f(i+1,j-1) + 2;
     * }
     * }
     * <p>
     * 其中我们可以初始化长度为 1(i=j) 和 2(i+1=j) 的 f(i,j)
     * 然后通过状态转换方程计算后面的
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        int length = s.length();
        int[][] palindromeLengths = new int[length][length];
        int max = 0;

        int[] resultIndex = new int[]{0, 1};
        for (int i = 0; i < length - 1; i++) {
            palindromeLengths[i][i] = 1;
            if (s.charAt(i) == s.charAt(i + 1)) {
                palindromeLengths[i][i + 1] = 2;
                max = 2;
                resultIndex[0] = i;
                resultIndex[1] = i + 1 + 1;
            }
        }

        palindromeLengths[length - 1][length - 1] = 1;

        for (int n = 2; n < length; n++) {
            for (int i = 0; i < length - n; i++) {
                int j = i + n;
                if (palindromeLengths[i + 1][j - 1] == 0 || s.charAt(i) != s.charAt(j)) {
                    palindromeLengths[i][j] = 0;
                } else {
                    palindromeLengths[i][j] = palindromeLengths[i + 1][j - 1] + 2;
                    if (palindromeLengths[i][j] > max) {
                        max = palindromeLengths[i][j];
                        resultIndex[0] = i;
                        resultIndex[1] = j + 1;
                    }
                }
            }
        }

        return s.substring(resultIndex[0], resultIndex[1]);
    }
}
