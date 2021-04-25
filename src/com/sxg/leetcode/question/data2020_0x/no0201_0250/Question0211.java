package com.sxg.leetcode.question.data2020_0x.no0201_0250;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: Question0211
 * @Author: Su_N
 * @Date: 2020/6/26 8:18
 * @Description: 构建字典树
 * 211. 添加与搜索单词 - 数据结构设计
 *
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addWord(word)
 * bool search(word)
 *
 * search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。
 *
 * 示例:
 *
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 *
 * 说明:
 *
 * 你可以假设所有单词都是由小写字母 a-z 组成的。
 */
public class Question0211 {
    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("a");
        wordDictionary.addWord("a");
        System.out.println(wordDictionary.search("."));
        System.out.println(wordDictionary.search("a"));
        System.out.println(wordDictionary.search("aa"));
        System.out.println(wordDictionary.search("a"));
        System.out.println(wordDictionary.search(".a"));
        System.out.println(wordDictionary.search("a."));
    }

}

class WordDictionary {
    private Map<Character, Map> root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        this.root = new HashMap<>();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        Map<Character, Map> current = root;
        if (word != null && !word.isEmpty()) {
            for (Character temp : word.toCharArray()) {
                Map<Character, Map> children = current.get(temp);
                if (children == null) {
                    children = new HashMap<>();
                    current.put(temp, children);
                }
                current = children;
            }
            current.put('#', new HashMap());
        }
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        List<Map> searchNodes = new ArrayList<>();
        searchNodes.add(root);
        for (Character c : word.toCharArray()) {
            if (searchNodes.isEmpty()) {
                return false;
            }
            searchNodes = searchFunction(searchNodes, c);
        }

        for (Map temp : searchNodes) {
            if (temp.containsKey('#')) {
                return true;
            }
        }

        return false;
    }

    private List<Map> searchFunction(List<Map> searchNodes, Character c) {
        List<Map> result = new ArrayList<>();
        searchNodes.forEach(node -> {
            if (c == '.') {
                node.forEach((k, v) -> {
                    if ((char) k != '#') {
                        result.add((Map) v);
                    }
                });

            } else {
                Object child = node.get(c);
                if (child != null) {
                    result.add((Map) child);
                }
            }
        });

        return result;
    }
}