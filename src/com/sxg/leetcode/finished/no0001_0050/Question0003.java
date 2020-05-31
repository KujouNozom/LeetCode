package com.sxg.leetcode.finished.no0001_0050;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName: Question0003
 * @Author: Su_N
 * @Date: 2020/4/26 22:47
 * @Description:  滑动窗口
 * 3. 无重复字符的最长子串
 * <p>
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class Question0003 {
    public static void main(String[] args) {
        Question0003 demo = new Question0003();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            System.out.println(demo.lengthOfLongestSubstring(scanner.nextLine()));
        }
        scanner.close();
    }

    public int lengthOfLongestSubstring(String s) {
        // 保存不包含某个字符的窗口的起始位置
        Map<Character, Integer> indexMap = new HashMap<Character, Integer>();
        int left = 0;
        int max = 0;

        for (int index = 0; index < s.length(); index++) {
            char temp = s.charAt(index);
            if (indexMap.containsKey(temp)) {
                left = Math.max(left, indexMap.get(temp));
            }

            // 求最大长度
            max = Math.max(max, index - left + 1);
            // 刷新这个不包含某个字符的窗口的起始位置
            indexMap.put(temp, index + 1);
        }

        return max;
    }
}
