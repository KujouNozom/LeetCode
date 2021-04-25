package com.sxg.leetcode.question.date2020_10;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @ClassName: com.sxg.leetcode.question.date2020_10.Question1585
 * @Author: Su_N
 * @Date: 2020/10/13 22:51
 * @Description: 逆序对
 * 思路就是 一个数字无法向前越过比他小的数字
 * 遍历数组 记录每个数字出现的位置，可以使用Map<Integer,List>
 * 从前往后遍历目标数组，如果比这个数字小的List都是空，或者这些List中的第一个值（第一次出现这个数的位置）大于当前位置（在这个数后面出现），则可以移动到指定位置
 * 如果所有数都满足，则可以移动，否则不行
 *
 *
 * 1585. 检查字符串是否可以通过排序子字符串得到另一个字符串
 *
 * 给你两个字符串 s 和 t ，请你通过若干次以下操作将字符串 s 转化成字符串 t ：
 *
 * 选择 s 中一个 非空 子字符串并将它包含的字符就地 升序 排序。
 *
 * 比方说，对下划线所示的子字符串进行操作可以由 "14234" 得到 "12344" 。
 *
 * 如果可以将字符串 s 变成 t ，返回 true 。否则，返回 false 。
 *
 * 一个 子字符串 定义为一个字符串中连续的若干字符。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "84532", t = "34852"
 * 输出：true
 * 解释：你可以按以下操作将 s 转变为 t ：
 * "84532" （从下标 2 到下标 3）-> "84352"
 * "84352" （从下标 0 到下标 2） -> "34852"
 *
 * 示例 2：
 *
 * 输入：s = "34521", t = "23415"
 * 输出：true
 * 解释：你可以按以下操作将 s 转变为 t ：
 * "34521" -> "23451"
 * "23451" -> "23415"
 *
 * 示例 3：
 *
 * 输入：s = "12345", t = "12435"
 * 输出：false
 *
 * 示例 4：
 *
 * 输入：s = "1", t = "2"
 * 输出：false
 *
 *
 *
 * 提示：
 *
 * s.length == t.length
 * 1 <= s.length <= 105
 * s 和 t 都只包含数字字符，即 '0' 到 '9' 。
 */
public class Question1585 {
    public static void main(String[] args) {
        Question1585 demo = new Question1585();
        demo.isTransformable("84532", "34852");
    }

    public boolean isTransformable(String s, String t) {
        Map<Integer, Queue<Integer>> indexMap = new HashMap<>();
        for (int index = 0; index < 10; index++) {
            indexMap.put(index + '0', new LinkedList<>());
        }

        char[] sChars = s.toCharArray();
        for (int index = 0; index < s.length(); index++) {
            indexMap.get((int) sChars[index]).offer(index);
        }

        char[] tChars = t.toCharArray();
        for (int index = 0; index < t.length(); index++) {
            char temp = tChars[index];
            Queue<Integer> currentIndexes = indexMap.get((int) temp);
            if (currentIndexes.isEmpty()) {
                return false;
            }

            int currentIndex = currentIndexes.poll();

            for (int charIndex = temp - 1; charIndex >= '0'; charIndex--) {
                Queue<Integer> indexes = indexMap.get(charIndex);
                if (!indexes.isEmpty()) {
                    if (indexes.peek() <= currentIndex) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
