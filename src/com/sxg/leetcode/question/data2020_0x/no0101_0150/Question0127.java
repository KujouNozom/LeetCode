package com.sxg.leetcode.question.data2020_0x.no0101_0150;

import java.util.*;

/**
 * @ClassName: Question0127
 * @Author: Su_N
 * @Date: 2020/5/28 23:05
 * @Description: 广度搜索树
 * 对单词做处理，每个单词的每一位置为*，例如 dog 处理为*og d*g do*
 * 构建邻接表，key是处理后的单词，后面跟着每个处理后可以构成这个单词的链表
 * 使用一个队列，初始为起始单词的处理后状态和计数1，使用元素（单词，计数）
 * 使用一个队列放置已经加入过队列的单词
 * 最终找到目标的时候计数值是多少 答案就是多少
 * <p>
 * 127. 单词接龙
 * <p>
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 * <p>
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * <p>
 * 说明:
 * <p>
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * 输出: 5
 * <p>
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * 返回它的长度 5。
 * <p>
 * 示例 2:
 * <p>
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * 输出: 0
 * <p>
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 */
public class Question0127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || wordList == null) {
            return 0;
        }

        if (!wordList.contains(endWord)) {
            return 0;
        }

        Map<String, List<String>> allWordDict = getAllWordDict(wordList);
        Queue<Truple2> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(new Truple2(beginWord, 1));
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            Truple2 temp = queue.poll();
            String tempWord = temp.word;
            int count = temp.count;
            int length = tempWord.length();
            for (int index = 0; index < length; index++) {
                String tempComboWord = tempWord.substring(0, index) + "*" + tempWord.substring(index + 1, length);
                List<String> tempList = allWordDict.get(tempComboWord);
                if (tempList != null) {
                    for (String word : tempList) {
                        if (word.equals(endWord)) {
                            return count + 1;
                        }

                        if (!visited.contains(word)) {
                            queue.offer(new Truple2(word, count + 1));
                            visited.add(word);
                        }
                    }
                }
            }

        }

        return 0;
    }

    private Map<String, List<String>> getAllWordDict(List<String> wordList) {
        Map<String, List<String>> result = new HashMap<>();

        for (String word : wordList) {
            int length = word.length();
            for (int index = 0; index < length; index++) {
                String temp = word.substring(0, index) + "*" + word.substring(index + 1, length);
                List<String> tempList = result.get(temp);
                if (tempList == null) {
                    tempList = new ArrayList<>();
                    result.put(temp, tempList);
                }

                tempList.add(word);
            }
        }

        return result;
    }

    class Truple2 {
        public String word;

        public int count;

        public Truple2(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
}
