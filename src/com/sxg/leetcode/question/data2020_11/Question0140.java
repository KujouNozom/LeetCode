package com.sxg.leetcode.question.data2020_11;

import java.util.*;

/**
 * @ClassName: com.sxg.leetcode.question.data2020_11.Question0140
 * @Author: Su_N
 * @Date: 2020/11/1 19:42
 * @Description: 动态规划，剪枝
 * 类似139，但是如果使用 139 中的动态规划，会超时，需要在动态规划的规程中记录，已i为起点，时候已经搜索过了
 * 如果搜索过了，直接获取结果
 *
 * 140. 单词拆分 II
 *
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 *
 * 说明：
 *
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 *
 * 示例 1：
 *
 * 输入:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 * "cats and dog",
 * "cat sand dog"
 * ]
 *
 * 示例 2：
 *
 * 输入:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * 输出:
 * [
 * "pine apple pen apple",
 * "pineapple pen apple",
 * "pine applepen apple"
 * ]
 * 解释: 注意你可以重复使用字典中的单词。
 *
 * 示例 3：
 *
 * 输入:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出:
 * []
 */
public class Question0140 {
    private String data;

    private int length;

    private Map<Integer, List<List<String>>> results;

    private Set<String> worlds;


    public List<String> wordBreak(String s, List<String> wordDict) {
        this.data = s;
        this.length = s.length();
        this.results = new HashMap<>(length);
        this.worlds = new HashSet<>(wordDict);

        List<List<String>> tempAns = function(0);
        List<String> ans = new ArrayList<>();

        tempAns.forEach(temp -> ans.add(String.join(" ", temp)));
        return ans;
    }

    private List<List<String>> function(int index) {
        if (results.containsKey(index)) {
            return results.get(index);
        }

        List<List<String>> tempResults = new LinkedList<>();
        if (index == length) {
            tempResults.add(new LinkedList<>());
        } else {
            for (int i = index + 1; i <= length; i++) {
                String tempString = data.substring(index, i);
                if (worlds.contains(tempString)) {
                    List<List<String>> tails = function(i);

                    for (List<String> tail : tails) {
                        LinkedList<String> result = new LinkedList<>(tail);
                        result.offerFirst(tempString);
                        tempResults.add(result);
                    }
                }
            }
        }

        results.put(index, tempResults);
        return tempResults;
    }
}
