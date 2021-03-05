package com.sxg.leetcode.question.data2020_04;

import java.util.*;

/**
 * @ClassName: Question0049
 * @Author: Su_N
 * @Date: 2020/4/30 21:30
 * @Description: 49. 字母异位词分组
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
