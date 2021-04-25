package com.sxg.leetcode.question.data2020_0x.no0151_0200;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName: Question0187
 * @Author: Su_N
 * @Date: 2020/6/17 22:18
 * @Description: 滑动窗口
 * 起点为s，长度为L，不断移动s，结果集合中没有的时候方法，有的时候不放入（可以使用set）
 * 因为每次比较的是字符串，所以比较慢，可以使用hash 或者bit 加速
 *
 * 187. 重复的DNA序列
 *
 * 所有 DNA 都由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 *
 * 编写一个函数来查找目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
 *
 *
 *
 * 示例：
 *
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC", "CCCCCAAAAA"]
 */
public class Question0187 {

    public static void main(String[] args) {
        Question0187 demo = new Question0187();
        demo.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
    }

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() < 10) {
            return result;
        }

        Set<String> tempSet = new HashSet<>();
        Set<String> tempResult = new HashSet<>();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(s, 0, 10);
        tempSet.add(stringBuilder.toString());

        for (int index = 10; index < s.length(); index++) {
            stringBuilder.deleteCharAt(0);
            stringBuilder.append(s.charAt(index));
            String temp = stringBuilder.toString();
            if (tempSet.contains(temp)) {
                tempResult.add(temp);
            } else {
                tempSet.add(temp);
            }
        }

        result.addAll(tempResult);
        return result;
    }
}
