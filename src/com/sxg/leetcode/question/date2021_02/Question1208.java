package com.sxg.leetcode.question;

/**
 * @ClassName: Question1208
 * @Author: Su_N
 * @Date: 2021/2/5 23:31
 * @Description: 1208. 尽可能使字符串相等 滑动窗口
 */
public class Question1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int ans = 0;
        int left = 0;
        int right = 0;
        int currentCost = Math.abs(t.charAt(right) - s.charAt(right));
        int length = s.length();
        while (right < length) {
            while (right < length && currentCost <= maxCost) {
                ans = Math.max(ans, right - left + 1);
                right++;
                if (right < length) {
                    currentCost = currentCost + (Math.abs(t.charAt(right) - s.charAt(right)));
                }
            }

            while (left <= length && currentCost > maxCost) {
                currentCost = currentCost - (Math.abs(t.charAt(left) - s.charAt(left)));
                left++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Question1208 demo = new Question1208();
        demo.equalSubstring("abcd", "cdef", 1);
    }
}
