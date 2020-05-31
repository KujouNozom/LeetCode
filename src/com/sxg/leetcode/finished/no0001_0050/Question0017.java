package com.sxg.leetcode.finished.no0001_0050;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: Question0017
 * @Author: Su_N
 * @Date: 2020/4/30 9:27
 * @Description: 17. 电话号码的字母组合
 * <p>
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 示例:
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * <p>
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */
public class Question0017 {

    private static Map<Character, String[]> numberStrings = new HashMap<>();

    static {
        numberStrings.put('2', new String[]{"a", "b", "c"});
        numberStrings.put('3', new String[]{"d", "e", "f"});
        numberStrings.put('4', new String[]{"g", "h", "i"});
        numberStrings.put('5', new String[]{"j", "k", "l"});
        numberStrings.put('6', new String[]{"m", "n", "o"});
        numberStrings.put('7', new String[]{"p", "q", "r", "s"});
        numberStrings.put('8', new String[]{"t", "u", "v"});
        numberStrings.put('9', new String[]{"w", "x", "y", "z"});
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits != null && !digits.isEmpty()) {
            function(result, "", 0, digits.toCharArray());
        }

        return result;
    }

    private void function(List<String> result, String current, int index, char[] digits) {
        if (index == digits.length) {
            result.add(current);
            return;
        }

        char temp = digits[index];
        String[] words = numberStrings.get(temp);
        for (String word : words) {
            function(result, current + word, index + 1, digits);
        }
    }
}
