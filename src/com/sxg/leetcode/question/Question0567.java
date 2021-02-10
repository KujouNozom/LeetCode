package com.sxg.leetcode.question;

import java.util.Arrays;

/**
 * @ClassName: Question0567
 * @Author: Su_N
 * @Date: 2021/2/10 20:29
 * @Description: 567. 字符串的排列
 */
public class Question0567 {
    public static void main(String[] args) {
        Question0567 demo = new Question0567();
        demo.checkInclusion("ab", "eidbaooo");
    }

    public boolean checkInclusion(String s1, String s2) {
        int length1 = s1.length();
        int length2 = s2.length();
        if (length1 > length2) {
            return false;
        }

        int[] values1 = new int[26];
        int[] values2 = new int[26];
        for (char c : s1.toCharArray()) {
            values1[c - 'a']++;
        }


        for (int index = 0; index < length1; index++) {
            values2[s2.charAt(index) - 'a']++;
        }

        if (Arrays.equals(values1, values2)) {
            return true;
        }
        for (int index = 0; index < length2 - length1; index++) {
            values2[s2.charAt(index + length1) - 'a']++;
            values2[s2.charAt(index) - 'a']--;
            if (Arrays.equals(values1, values2)) {
                return true;
            }
        }
        return false;
    }
}
