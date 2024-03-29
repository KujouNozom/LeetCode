package com.sxg.leetcode.question.data2020_10;

/**
 * @ClassName: com.sxg.leetcode.question.date2020_10.Question0925
 * @Author: Su_N
 * @Date: 2020/10/21 23:51
 * @Description: 双指针
 * 925. 长按键入
 *
 * 你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
 *
 * 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
 *
 *
 *
 * 示例 1：
 *
 * 输入：name = "alex", typed = "aaleex"
 * 输出：true
 * 解释：'alex' 中的 'a' 和 'e' 被长按。
 *
 * 示例 2：
 *
 * 输入：name = "saeed", typed = "ssaaedd"
 * 输出：false
 * 解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样。
 *
 * 示例 3：
 *
 * 输入：name = "leelee", typed = "lleeelee"
 * 输出：true
 *
 * 示例 4：
 *
 * 输入：name = "laiden", typed = "laiden"
 * 输出：true
 * 解释：长按名字中的字符并不是必要的。
 *
 *
 *
 * 提示：
 *
 * name.length <= 1000
 * typed.length <= 1000
 * name 和 typed 的字符都是小写字母。
 */
public class Question0925 {
    public boolean isLongPressedName(String name, String typed) {
        int indexName = 0;
        int indexTyped = 0;
        int count = 0;
        char pre = name.charAt(0);

        while (indexName < name.length() && indexTyped < typed.length()) {
            // 统计 name 当前字符连续次数
            while (indexName < name.length() && name.charAt(indexName) == pre) {
                count++;
                indexName++;
            }
            // 统计 name 当前字符连续次数和 typed 当前字符出现次数差值
            while (indexTyped < typed.length() && typed.charAt(indexTyped) == pre) {
                count--;
                indexTyped++;
            }

            // 判断
            if (count > 0) {
                return false;
            } else if (indexName < name.length()) {
                count = 0;
                pre = name.charAt(indexName);

            }
        }

        return indexTyped == typed.length() && indexName == name.length();
    }
}
