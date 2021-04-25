package com.sxg.leetcode.question.data2020_0x.no0401_0450;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Question0438
 * @Author: Su_N
 * @Date: 2020/8/11 20:35
 * @Description: 438. 找到字符串中所有字母异位词
 *
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 *
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 *
 * 说明：
 *
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 *
 * 示例 1:
 *
 * 输入:
 * s: "cbaebabacd" p: "abc"
 *
 * 输出:
 * [0, 6]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 *
 * 示例 2:
 *
 * 输入:
 * s: "abab" p: "ab"
 *
 * 输出:
 * [0, 1, 2]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 */
public class Question0438 {
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || s.length() < p.length()) {
            return new ArrayList<>();
        }

        int windowLength = p.length();
        int sLength = s.length();

        int[] targetCharCounts = new int[26];
        int[] currentCharCounts = new int[26];

        for (int index = 0; index < windowLength; index++) {
            targetCharCounts[p.charAt(index) - 'a']++;
            currentCharCounts[s.charAt(index) - 'a']++;
        }

        List<Integer> answers = new ArrayList<>();
        if (Arrays.equals(targetCharCounts, currentCharCounts)) {
            answers.add(0);
        }

        for (int index = 0; index + windowLength < sLength; index++) {
            currentCharCounts[s.charAt(index) - 'a']--;
            currentCharCounts[s.charAt(index + windowLength) - 'a']++;
            if (Arrays.equals(targetCharCounts, currentCharCounts)) {
                answers.add(index + 1);
            }
        }

        return answers;
    }
}
