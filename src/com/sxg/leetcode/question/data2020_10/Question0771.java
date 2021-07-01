package com.sxg.leetcode.question.data2020_10;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: Question0771
 * @Author: Su_N
 * @Date: 2020/10/2 8:33
 * @Description: 使用 Hash 快速查找
 * 771. 宝石与石头
 *
 * 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 *
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 *
 * 示例 1:
 *
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 *
 * 示例 2:
 *
 * 输入: J = "z", S = "ZZ"
 * 输出: 0
 *
 * 注意:
 *
 * S 和 J 最多含有50个字母。
 * J 中的字符不重复。
 */
public class Question0771 {
    public int numJewelsInStones(String J, String S) {
        if (J.isEmpty()) {
            return 0;
        }

        Set<Character> jSet = new HashSet<>();
        for (char c : J.toCharArray()) {
            jSet.add(c);
        }

        int count = 0;
        for (char c : S.toCharArray()) {
            if (jSet.contains(c)) {
                count++;
            }
        }

        return count;
    }
}
