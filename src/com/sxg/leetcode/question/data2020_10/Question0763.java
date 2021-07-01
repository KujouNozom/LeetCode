package com.sxg.leetcode.question.data2020_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName: Question0763
 * @Author: Su_N
 * @Date: 2020/10/22 22:19
 * @Description: 区间
 * 计算每个字母的区间，排序这些区间，如果两个区间重合，计算重合后的新区间，如果区间分开，则加入到结果中
 * 763. 划分字母区间
 *
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 *
 *
 *
 * 示例 1：
 *
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 *
 *
 *
 * 提示：
 *
 * S的长度在[1, 500]之间。
 * S只包含小写字母 'a' 到 'z' 。
 */
public class Question0763 {
    public List<Integer> partitionLabels(String S) {
        int[][] indexes = getFirstAndLastIndex(S);
        Arrays.sort(indexes, Comparator.comparingInt(a -> a[0]));

        List<Integer> resultList = new ArrayList<>();
        int left = 0;
        int right = 0;
        for (int[] temp : indexes) {
            if (temp[0] != -1) {
                // 如果当前字符第一次出现的位置，在前面单词组成的集合右边界之外，则前面单子组成的集合可以确定，添加到结果集合
                if (temp[0] > right) {
                    resultList.add(right - left + 1);
                    // 集合左右边界重置
                    left = temp[0];
                    right = temp[1];
                } else {
                    // 如果当前字符第一次出现位置在集合边界内，则更新集合边界
                    right = right < temp[1] ? temp[1] : right;
                }
            }
        }

        resultList.add(right - left + 1);
        return resultList;
    }

    private int[][] getFirstAndLastIndex(String word) {
        int[][] indexes = new int[26][0];
        for (int index = 0; index < 26; index++) {
            indexes[index] = new int[]{-1, -1};
        }
        for (int index = 0; index < word.length(); index++) {
            char key = word.charAt(index);
            int charIndex = key - 'a';
            if (indexes[charIndex][0] == -1) {
                indexes[charIndex][0] = index;
                indexes[charIndex][1] = index;
            } else {
                indexes[charIndex][1] = index;
            }
        }
        return indexes;
    }
}
