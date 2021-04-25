package com.sxg.leetcode.question.data2020_0x.no0301_0350;

import java.util.*;

/**
 * @ClassName: Question0316
 * @Author: Su_N
 * @Date: 2020/6/18 22:47
 * @Description: 使用一个栈完成
 * 首先遍历一遍字符串，获取每个字母最后出现的位置，结果使用一个 lastIndex 的 Map 存放
 * 声明一个 Set 存放当前已经存在的字母
 * 声明一个 Stack 存放保持字典序的当前结果
 * 遍历字符串，如果当前字符在 set 中不存在，则添加，但是添加到时候要做一些处理
 * 栈顶元素如果字典序比当前元素大，并且后面还会出现当前元素，删除栈顶元素，同时删除 Set中的元素，一直执行知道栈顶元素不满足条件
 *
 *
 * 316. 去除重复字母
 *
 * 给你一个仅包含小写字母的字符串，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 *
 *
 *
 * 示例 1:
 *
 * 输入: "bcabc"
 * 输出: "abc"
 *
 * 示例 2:
 *
 * 输入: "cbacdcbc"
 * 输出: "acdb"
 *
 *
 *
 * 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters 相同
 */
public class Question0316 {
    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> lastIndex = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastIndex.put(s.charAt(i), i);
        }

        Set<Character> set = new HashSet<>();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (!set.contains(current)) {
                while (!stack.isEmpty() && stack.peek() > current && lastIndex.get(stack.peek()) > i) {
                    set.remove(stack.pop());
                }

                set.add(current);
                stack.push(current);
            }
        }

        StringBuilder result = new StringBuilder();
        stack.forEach(c -> result.append(c));
        return result.toString();
    }
}
