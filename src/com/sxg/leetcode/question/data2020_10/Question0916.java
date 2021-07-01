package com.sxg.leetcode.question.data2020_10;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: Question0916
 * @Author: Su_N
 * @Date: 2020/10/20 22:34
 * @Description: 正常
 * 统计 B 中每个字母在每个单词中出现的最多次数 int[26]
 * 遍历 A 中的每个单词，统计每个字符出现的次数，和 B 统计的结果统计比较，如果每个字母都是 A 的单词出现次数多，那么就是子集
 * 916. 单词子集
 *
 * 我们给出两个单词数组 A 和 B。每个单词都是一串小写字母。
 *
 * 现在，如果 b 中的每个字母都出现在 a 中，包括重复出现的字母，那么称单词 b 是单词 a 的子集。 例如，“wrr” 是 “warrior” 的子集，但不是 “world” 的子集。
 *
 * 如果对 B 中的每一个单词 b，b 都是 a 的子集，那么我们称 A 中的单词 a 是通用的。
 *
 * 你可以按任意顺序以列表形式返回 A 中所有的通用单词。
 *
 *
 *
 * 示例 1：
 *
 * 输入：A = ["amazon","apple","facebook","google","leetcode"], B = ["e","o"]
 * 输出：["facebook","google","leetcode"]
 *
 * 示例 2：
 *
 * 输入：A = ["amazon","apple","facebook","google","leetcode"], B = ["l","e"]
 * 输出：["apple","google","leetcode"]
 *
 * 示例 3：
 *
 * 输入：A = ["amazon","apple","facebook","google","leetcode"], B = ["e","oo"]
 * 输出：["facebook","google"]
 *
 * 示例 4：
 *
 * 输入：A = ["amazon","apple","facebook","google","leetcode"], B = ["lo","eo"]
 * 输出：["google","leetcode"]
 *
 * 示例 5：
 *
 * 输入：A = ["amazon","apple","facebook","google","leetcode"], B = ["ec","oc","ceo"]
 * 输出：["facebook","leetcode"]
 *
 *
 *
 * 提示：
 *
 * 1 <= A.length, B.length <= 10000
 * 1 <= A[i].length, B[i].length <= 10
 * A[i] 和 B[i] 只由小写字母组成。
 * A[i] 中所有的单词都是独一无二的，也就是说不存在 i != j 使得 A[i] == A[j]。
 */
public class Question0916 {
    public List<String> wordSubsets(String[] A, String[] B) {
        // 统计 B 中每个字母在每个单词中出现的最多次数
        int[] countB = new int[26];
        for (int index = 0; index < B.length; index++) {
            int[] tempCounts = new int[26];
            for (char world : B[index].toCharArray()) {
                tempCounts[world - 'a']++;
            }
            for (int wordIndex = 0; wordIndex < 26; wordIndex++) {
                countB[wordIndex] = Math.max(countB[wordIndex], tempCounts[wordIndex]);
            }
        }

        List<String> ans = new LinkedList<>();
        for (int index = 0; index < A.length; index++) {
            // 统计 A 中某个单词中字母出现的次数
            int[] countA = new int[26];
            for (char world : A[index].toCharArray()) {
                countA[world - 'a']++;
            }

            // 判断是否是子集
            if (check(countB, countA)) {
                ans.add(A[index]);
            }
        }

        return ans;
    }

    private boolean check(int[] countB, int[] countA) {
        for (int wordIndex = 0; wordIndex < 26; wordIndex++) {
            if (countA[wordIndex] < countB[wordIndex]) {
                return false;
            }
        }
        return true;
    }
}
