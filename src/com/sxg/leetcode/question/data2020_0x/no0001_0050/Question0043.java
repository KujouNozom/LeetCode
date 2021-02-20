package com.sxg.leetcode.question.data2020_0x.no0001_0050;

/**
 * @ClassName: Question0043
 * @Author: Su_N
 * @Date: 2020/8/2 20:17
 * @Description: 43. 字符串相乘
 *
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 *
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 *
 * 说明：
 *
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */
public class Question0043 {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int[] results = new int[num1.length() + num2.length()];
        for (int index1 = num1.length() - 1; index1 >= 0; index1--) {
            for (int index2 = num2.length() - 1; index2 >= 0; index2--) {
                int loc = index1 + index2 + 1;
                int tempResult = (num1.charAt(index1) - '0') * (num2.charAt(index2) - '0') + results[loc];
                results[loc] = tempResult % 10;
                results[loc - 1] += tempResult / 10;
            }
        }

        StringBuilder answer = new StringBuilder();
        int index = 0;
        while (results[index] == 0) {
            index++;
        }

        for (; index < results.length; index++) {
            answer.append(results[index]);
        }

        return answer.toString();
    }
}
