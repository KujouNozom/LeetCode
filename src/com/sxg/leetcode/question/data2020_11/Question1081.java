package com.sxg.leetcode.question.data2020_11;

import java.util.*;

/**
 * @ClassName: com.sxg.leetcode.question.data2020_11.Question1081
 * @Author: Su_N
 * @Date: 2020/11/4 22:01
 * @Description: 堆栈
 * 首先遍历一遍字符串，获取每个字母最后出现的位置，结果使用一个 lastIndex 的 Map 存放
 * 声明一个 Set 存放当前已经存在的字母
 * 声明一个 Stack 存放保持字典序的当前结果
 * 遍历字符串，如果当前字符在 set 中不存在，则添加，但是添加到时候要做一些处理
 * 栈顶元素如果字典序比当前元素大，并且后面还会出现当前元素，删除栈顶元素，同时删除 Set中的元素，一直执行知道栈顶元素不满足条件
 *
 *
 * 1081. 不同字符的最小子序列
 *
 * 返回字符串 text 中按字典序排列最小的子序列，该子序列包含 text 中所有不同字符一次。
 *
 *
 *
 * 示例 1：
 *
 * 输入："cdadabcc"
 * 输出："adbc"
 *
 * 示例 2：
 *
 * 输入："abcd"
 * 输出："abcd"
 *
 * 示例 3：
 *
 * 输入："ecbacba"
 * 输出："eacb"
 *
 * 示例 4：
 *
 * 输入："leetcode"
 * 输出："letcod"
 *
 *
 *
 * 提示：
 *
 * 1 <= text.length <= 1000
 * text 由小写英文字母组成
 */
public class Question1081 {
    public String smallestSubsequence(String s) {
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
