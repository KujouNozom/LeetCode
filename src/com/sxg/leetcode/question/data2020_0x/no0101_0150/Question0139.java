package com.sxg.leetcode.question.data2020_0x.no0101_0150;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName: Question0139
 * @Author: Su_N
 * @Date: 2020/6/3 22:39
 * @Description: 可以使用暴力解法回溯，这里使用动态规划
 * <p>
 * 字符串S 可以拆分为 S1 和 S2，如果 S1,S2都满足条件，S就满足条件
 * 我们使用f(i) 表示字符串起始到i的子串是否满足条件
 * 初始 f(0) = true
 * 转移方程是 f(i)算法：
 * 遍历f(0)到f(i-1），如果f(k) = true,那么用k分隔当前串，0-k肯定满足，只要k-i满足，那么f(i) = true
 * <p>
 * 重复这个流程，知道计算出来f(n)
 * 139. 单词拆分
 * <p>
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * <p>
 * 说明：
 * <p>
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * <p>
 * 示例 2：
 * <p>
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 * 注意你可以重复使用字典中的单词。
 * <p>
 * 示例 3：
 * <p>
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 */
public class Question0139 {
    public static void main(String[] args) {
        Question0139 demo = new Question0139();
        List<String> datas = Arrays.asList("leet", "code");
        System.out.println(demo.wordBreak("leetcode", datas));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0) {
            return true;
        }

        Set<String> dict = new HashSet<>(wordDict);
        int length = s.length();
        boolean[] dp = new boolean[length + 1];
        dp[0] = true;

        for (int i = 1; i <= length; i++) {
            for (int k = 0; k <= i; k++) {
                if (dp[k] && dict.contains(s.substring(k, i))) {
                    dp[i] = true;
                }
            }
        }

        return dp[length];
    }
}
