package com.sxg.leetcode.question.data2020_04;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName: Question0003
 * @Author: Su_N
 * @Date: 2020/4/26 22:47
 * @Description: 3. 无重复字符的最长子串 [滑动窗口]
 */
public class Question0003 {
    public static void main(String[] args) {
        Question0003 demo = new Question0003();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            System.out.println(demo.lengthOfLongestSubstring(scanner.nextLine()));
        }
        scanner.close();
    }

    public int lengthOfLongestSubstring(String s) {
        // 保存不包含某个字符的窗口的起始位置
        Map<Character, Integer> indexMap = new HashMap<Character, Integer>();
        int left = 0;
        int max = 0;

        for (int index = 0; index < s.length(); index++) {
            char temp = s.charAt(index);
            if (indexMap.containsKey(temp)) {
                left = Math.max(left, indexMap.get(temp));
            }

            // 求最大长度
            max = Math.max(max, index - left + 1);
            // 刷新这个不包含某个字符的窗口的起始位置
            indexMap.put(temp, index + 1);
        }

        return max;
    }
}
