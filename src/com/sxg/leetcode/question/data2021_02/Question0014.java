package com.sxg.leetcode.question;

/**
 * @ClassName: Question0014
 * @Author: Su_N
 * @Date: 2021/2/7 23:09
 * @Description: 14. 最长公共前缀
 */
public class Question0014 {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder();
        if (strs == null || strs.length == 0) {
            return ans.toString();
        }

        for (int index = 0; ; index++) {
            if (strs[0].length() <= index) {
                return ans.toString();
            }

            char value = strs[0].charAt(index);
            for (String temp : strs) {
                if (temp.length() <= index || temp.charAt(index) != value) {
                    return ans.toString();
                }
            }
            ans.append(value);
        }
    }
}
