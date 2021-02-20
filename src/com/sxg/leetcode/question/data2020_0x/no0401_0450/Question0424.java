package com.sxg.leetcode.question.data2020_0x.no0401_0450;

/**
 * @ClassName: Question0424
 * @Author: Su_N
 * @Date: 2020/8/6 18:35
 * @Description: 滑动窗口
 *
 * 424. 替换后的最长重复字符
 *
 * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
 *
 * 注意:
 * 字符串长度 和 k 不会超过 104。
 *
 * 示例 1:
 *
 * 输入:
 * s = "ABAB", k = 2
 *
 * 输出:
 * 4
 *
 * 解释:
 * 用两个'A'替换为两个'B',反之亦然。
 *
 * 示例 2:
 *
 * 输入:
 * s = "AABABBA", k = 1
 *
 * 输出:
 * 4
 *
 * 解释:
 * 将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
 * 子串 "BBBB" 有最长重复字母, 答案为 4。
 */
public class Question0424 {
    private int aa;

    public static void main(String[] args) {
        System.out.println('A' - 0);
    }


    public int characterReplacement(String s, int k) {
        aa = 10;
        int[] wordCounts = new int[26];
        int currentMaxCount = 0;
        int answer = 0;

        char[] wordArray = s.toCharArray();
        int left = 0;
        int right = 0;
        for (; right < wordArray.length; ) {
            wordCounts[wordArray[right] - 65]++;
            currentMaxCount = Math.max(currentMaxCount, wordCounts[wordArray[right] - 65]);

            if (right - left + 1 <= currentMaxCount + k) {
                answer = Math.max(right - left + 1, answer);
            } else {
                wordCounts[wordArray[left] - 65]--;
                left++;
            }

            right++;
        }
        return answer;
    }
}
