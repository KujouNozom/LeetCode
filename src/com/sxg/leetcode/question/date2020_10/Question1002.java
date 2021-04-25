package com.sxg.leetcode.question.date2020_10;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: com.sxg.leetcode.question.date2020_10.Question1002
 * @Author: Su_N
 * @Date: 2020/10/14 22:13
 * @Description: 遍历每个字符串统计每个字母出现次数，使用数组记录每个字母弹一个字符串出现的的最小值
 * 1002. 查找常用字符
 *
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 *
 * 你可以按任意顺序返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 *
 * 示例 2：
 *
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 *
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] 是小写字母
 */
public class Question1002 {
    public List<String> commonChars(String[] A) {
        int[] mines = new int[26];
        Arrays.fill(mines, Integer.MAX_VALUE);

        for (String tempString : A) {
            int[] tempArray = new int[26];
            for (char tempChar : tempString.toCharArray()) {
                tempArray[tempChar - 'a']++;
            }

            for (int index = 0; index < 26; index++) {
                mines[index] = Math.min(mines[index], tempArray[index]);
            }
        }

        List<String> result = new LinkedList<>();
        for (int index = 0; index < 26; index++) {
            String word = String.valueOf((char) ('a' + index));
            for (int count = 0; count < mines[index]; count++) {
                result.add(word);
            }
        }

        return result;
    }
}
