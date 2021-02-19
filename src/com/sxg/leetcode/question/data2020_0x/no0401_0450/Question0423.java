package com.sxg.leetcode.question.data2020_0x.no0401_0450;

/**
 * @ClassName: Question0423
 * @Author: Su_N
 * @Date: 2020/8/5 20:29
 * @Description: 423. 从英文中重建数字
 *
 * 给定一个非空字符串，其中包含字母顺序打乱的英文单词表示的数字0-9。按升序输出原始的数字。
 *
 * 注意:
 *
 * 输入只包含小写英文字母。
 * 输入保证合法并可以转换为原始的数字，这意味着像 "abc" 或 "zerone" 的输入是不允许的。
 * 输入字符串的长度小于 50,000。
 *
 * 示例 1:
 *
 * 输入: "owoztneoer"
 *
 * 输出: "012" (zeroonetwo)
 *
 * 示例 2:
 *
 * 输入: "fviefuro"
 *
 * 输出: "45" (fourfive)
 */
public class Question0423 {
    public String originalDigits(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        int[] charCounts = new int[26];
        int[] ansCounts = new int[10];
        for (char temp : s.toCharArray()) {
            charCounts[temp - 97]++;
        }
        //count(zero(z)) = count(z)
        ansCounts[0] = charCounts['z' - 97];
        //count(two(w)) = count(w)
        ansCounts[2] = charCounts['w' - 97];
        //count(four(u)) = count(u)
        ansCounts[4] = charCounts['u' - 97];
        // count(six(x)) = count(x)
        ansCounts[6] = charCounts['x' - 97];
        // count(eight(g)) = count(g)
        ansCounts[8] = charCounts['g' - 97];
        // count(one(o)) = count(o) - count(zero) - count(two) - count(four)
        ansCounts[1] = charCounts['o' - 97] - ansCounts[0] - ansCounts[2] - ansCounts[4];
        // count(three(r)) =count(r) - count(zero) - count(four)
        ansCounts[3] = charCounts['r' - 97] - ansCounts[0] - ansCounts[4];
        // count(five(f)) = count(f) - count(four)
        ansCounts[5] = charCounts['f' - 97] - ansCounts[4];
        // count(seven(s)) = count(s) - count(six)
        ansCounts[7] = charCounts['s' - 97] - ansCounts[6];
        // count(nine(i)) = count(i) - count(five) - count(six) - count(eight)
        ansCounts[9] = charCounts['i' - 97] - ansCounts[5] - ansCounts[6] - ansCounts[8];

        StringBuilder stringBuilder = new StringBuilder();
        for (int index = 0; index < ansCounts.length; index++) {
            for (int count = 0; count < ansCounts[index]; count++) {
                stringBuilder.append(index);
            }
        }

        return stringBuilder.toString();
    }
}
