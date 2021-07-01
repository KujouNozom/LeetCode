package com.sxg.leetcode.question.data2021_04;

import java.util.Scanner;

/**
 * @ClassName: Question0005
 * @Author: Su_N
 * @Date: 2020/4/26 22:58
 * @Description: 5. 最长回文子串 [动态规划]
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

    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        int length = s.length();
        int[][] palindromeLengths = new int[length][length];
        int max = 0;

        int[] resultIndex = new int[] {0, 1};
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
