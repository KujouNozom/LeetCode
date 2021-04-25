package com.sxg.leetcode.question.data2020_08;

/**
 * @ClassName: Question0043
 * @Author: Su_N
 * @Date: 2020/8/2 20:17
 * @Description: 43. 字符串相乘
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
