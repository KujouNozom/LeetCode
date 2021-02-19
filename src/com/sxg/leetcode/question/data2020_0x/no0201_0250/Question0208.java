package com.sxg.leetcode.question.data2020_0x.no0201_0250;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Question0208
 * @Author: Su_N
 * @Date: 2020/6/23 23:05
 * @Description: 208. 实现 Trie (前缀树)
 *
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 *
 * 示例:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 *
 * 说明:
 *
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 */
public class Question0208 {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("app");
        trie.insert("apple");
        trie.insert("beer");
        trie.insert("add");
        trie.insert("jam");
        trie.insert("rental");
        System.out.println(trie.search("apps"));
        System.out.println(trie.search("app"));
        System.out.println(trie.search("ad"));
        System.out.println(trie.search("applepie"));
        System.out.println(trie.search("rest"));
        System.out.println(trie.search("jan"));
        System.out.println(trie.search("rent"));
    }
}


class Trie {
    Map<Character, Map> nodes;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        this.nodes = new HashMap<>();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Map<Character, Map> current = nodes;

        for (char temp : word.toCharArray()) {
            if (!current.containsKey(temp)) {
                current.put(temp, new HashMap<Character, Map>());
            }

            current = current.get(temp);
        }

        current.put('#', new HashMap<Character, Map>());
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Map<Character, Map> current = searchImpl(word);
        return current != null && current.containsKey('#');
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Map<Character, Map> current = searchImpl(prefix);
        return current != null;
    }

    private Map<Character, Map> searchImpl(String word) {
        Map<Character, Map> current = nodes;

        for (char temp : word.toCharArray()) {
            if (!current.containsKey(temp)) {
                return null;
            }

            current = current.get(temp);
        }

        return current;
    }
}