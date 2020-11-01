package com.sxg.leetcode.question.date2020_10;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: com.sxg.leetcode.question.date2020_10.Question1593
 * @Author: Su_N
 * @Date: 2020/10/16 20:51
 * @Description: 深度搜索
 * 遍历每个可以切分的点，如果切分的字符串之前有，就不能切分，否则就切分
 * 深搜，注意每次添加字符串，然后递归深搜，然后回溯（删除字符串）
 * 类似于所有可以切分点的全排列
 *
 * 1593. 拆分字符串使唯一子字符串的数目最大
 *
 * 给你一个字符串 s ，请你拆分该字符串，并返回拆分后唯一子字符串的最大数目。
 *
 * 字符串 s 拆分后可以得到若干 非空子字符串 ，这些子字符串连接后应当能够还原为原字符串。但是拆分出来的每个子字符串都必须是 唯一的 。
 *
 * 注意：子字符串 是字符串中的一个连续字符序列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "ababccc"
 * 输出：5
 * 解释：一种最大拆分方法为 ['a', 'b', 'ab', 'c', 'cc'] 。像 ['a', 'b', 'a', 'b', 'c', 'cc'] 这样拆分不满足题目要求，因为其中的 'a' 和 'b' 都出现了不止一次。
 *
 * 示例 2：
 *
 * 输入：s = "aba"
 * 输出：2
 * 解释：一种最大拆分方法为 ['a', 'ba'] 。
 *
 * 示例 3：
 *
 * 输入：s = "aa"
 * 输出：1
 * 解释：无法进一步拆分字符串。
 *
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 16
 *
 * s 仅包含小写英文字母
 */
public class Question1593 {
    private int ans;

    private String data;

    private int length;

    public int maxUniqueSplit(String s) {
        ans = -1;
        data = s;
        length = s.length();
        function(new HashSet<>(), 0);
        return ans;
    }

    private void function(Set<String> words, int start) {
        if (start >= length) {
            ans = Math.max(words.size(), ans);
        }

        int end = start + 1;
        for (; end <= length; end++) {
            String temp = data.substring(start, end);
            if (!words.contains(temp)) {
                words.add(temp);
                function(words, end);
                words.remove(temp);
            }
        }
    }

    public static void main(String[] args) {
        new Question1593().maxUniqueSplit("wwwzfvedwfvhsww");
    }
}
