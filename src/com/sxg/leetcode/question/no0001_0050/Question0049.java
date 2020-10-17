package com.sxg.leetcode.question.no0001_0050;

import java.util.*;

/**
 * @ClassName: Question0049
 * @Author: Su_N
 * @Date: 2020/4/30 21:30
 * @Description: 49. 字母异位词分组
 * <p>
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * <p>
 * 说明：
 * <p>
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */
public class Question0049 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> stringMap = new LinkedHashMap<>();

        for (String temp : strs) {
            char[] chars = temp.toCharArray();
            Arrays.sort(chars);
            String sortString = new String(chars);

            List<String> stringList = stringMap.get(sortString);
            if (stringList == null) {
                stringList = new ArrayList<>();
                stringMap.put(sortString, stringList);
            }
            stringList.add(temp);
        }

        List<List<String>> result = new ArrayList<>();
        result.addAll(stringMap.values());

        return result;
    }
}
