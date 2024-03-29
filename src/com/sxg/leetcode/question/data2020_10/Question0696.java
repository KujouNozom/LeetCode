package com.sxg.leetcode.question.data2020_10;

/**
 * @ClassName: Question0696
 * @Author: Su_N
 * @Date: 2020/8/28 20:47
 * @Description: 696. 计数二进制子串
 *
 * 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
 *
 * 重复出现的子串要计算它们出现的次数。
 *
 * 示例 1 :
 *
 * 输入: "00110011"
 * 输出: 6
 * 解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
 *
 * 请注意，一些重复出现的子串要计算它们出现的次数。
 *
 * 另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
 *
 * 示例 2 :
 *
 * 输入: "10101"
 * 输出: 4
 * 解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
 *
 * 注意：
 *
 * s.length 在1到50,000之间。
 * s 只包含“0”或“1”字符。
 */
public class Question0696 {
    public int countBinarySubstrings(String s) {
        int preCount = 0;
        int answer = 0;
        int length = s.length();

        for (int index = 0; index < length; ) {
            char currentWord = s.charAt(index);
            int currentCount = 1;
            while (++index < length && currentWord == s.charAt(index)) currentCount++;
            answer += Math.min(preCount, currentCount);
            preCount = currentCount;
        }
        return answer;
    }
}
