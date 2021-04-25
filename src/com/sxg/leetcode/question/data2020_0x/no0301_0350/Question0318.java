package com.sxg.leetcode.question.data2020_0x.no0301_0350;

/**
 * @ClassName: Question0318
 * @Author: Su_N
 * @Date: 2020/7/19 21:40
 * @Description: 位操作
 *
 * 使用26个位表示每个字母，一个单词包含那个字母，对应位置设置成1，两个单词的位运算与之后等于0，就是没有重复单词
 * 预处理，先计算每个单词的位表示
 *
 * 318. 最大单词长度乘积
 *
 * 给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
 *
 * 示例 1:
 *
 * 输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
 * 输出: 16
 * 解释: 这两个单词为 "abcw", "xtfn"。
 *
 * 示例 2:
 *
 * 输入: ["a","ab","abc","d","cd","bcd","abcd"]
 * 输出: 4
 * 解释: 这两个单词为 "ab", "cd"。
 *
 * 示例 3:
 *
 * 输入: ["a","aa","aaa","aaaa"]
 * 输出: 0
 * 解释: 不存在这样的两个单词。
 */
public class Question0318 {
    public static void main(String[] args) {
        Question0318 demo = new Question0318();
        demo.maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"});
    }

    private int[] lengths;

    private int[] wordBits;

    private int length;

    public int maxProduct(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }

        length = words.length;
        lengths = new int[length];
        wordBits = new int[length];

        for (int index = 0; index < length; index++) {
            lengths[index] = words[index].length();
            wordBits[index] = getWordBit(words[index]);
        }

        int answer = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if ((wordBits[i] & wordBits[j]) == 0) {
                    answer = Math.max(answer, lengths[i] * lengths[j]);
                }
            }
        }

        return answer;
    }

    private int getWordBit(String input) {
        int wordBit = 0;
        for (char temp : input.toCharArray()) {
            int tempBit = 1 << (temp - 'a');
            wordBit |= tempBit;
        }

        return wordBit;
    }
}
