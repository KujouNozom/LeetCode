package com.sxg.leetcode.question.data2021_04;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName: Question0966
 * @Author: Su_N
 * @Date: 2021/3/3 22:40
 * @Description: 966. 元音拼写检查器 [Hash]
 */
public class Question0966 {
    private Set<String> srSet;

    private Map<String, String> lowMap;

    private Map<String, String> vowelsMap;

    public String[] spellchecker(String[] wordlist, String[] queries) {
        initMap(wordlist);
        String[] ans = buildAns(queries);
        return ans;
    }

    private String[] buildAns(String[] queries) {
        int length = queries.length;
        String[] ans = new String[length];
        for (int index = 0; index < length; index++) {
            String src = queries[index];
            if (srSet.contains(src)) {
                ans[index] = src;
                continue;
            }

            String low = src.toLowerCase();
            if (lowMap.containsKey(low)) {
                ans[index] = lowMap.get(low);
                continue;
            }

            String vowels = replaceVowels(low);
            if (vowelsMap.containsKey(vowels)) {
                ans[index] = vowelsMap.get(vowels);
                continue;
            }
            ans[index] = "";

        }
        return ans;
    }

    private void initMap(String[] wordlist) {
        int length = wordlist.length;
        srSet = new HashSet<>(length);
        lowMap = new HashMap<>(length);
        vowelsMap = new HashMap<>(length);

        for (int index = 0; index < length; index++) {
            String src = wordlist[index];
            srSet.add(src);

            String low = src.toLowerCase();
            if (!lowMap.containsKey(low)) {
                lowMap.put(low, src);
            }

            String vowels = replaceVowels(low);
            if (!vowelsMap.containsKey(vowels)) {
                vowelsMap.put(vowels, src);
            }
        }
    }

    public String replaceVowels(String word) {
        StringBuilder ans = new StringBuilder();
        for (char c : word.toCharArray()) {
            ans.append((c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') ? '*' : c);
        }
        return ans.toString();
    }
}
