package com.sxg.leetcode.question.data2020_05;

/**
 * @ClassName: Question0008
 * @Author: Su_N
 * @Date: 2020/5/1 8:07
 * @Description: 8. 字符串转换整数 (atoi) [状态机]
 */
public class Question0008 {
    public static void main(String[] args) {
        Question0008 demo = new Question0008();
        demo.myAtoi("-91283472332");
    }

    public int myAtoi(String str) {
        str = str.trim();
        if (str == null || str.isEmpty()) {
            return 0;
        }
        String flag = "";
        if (str.startsWith("+") || str.startsWith("-")) {
            flag = str.substring(0, 1);
            str = str.substring(1);
        }

        StringBuilder data = new StringBuilder();

        for (char temp : str.toCharArray()) {
            if (temp < '0' || temp > '9') {
                break;
            }

            data.append(temp);
        }

        if (data.toString().isEmpty()) {
            return 0;
        }

        while (data.length() != 0 && data.charAt(0) == '0') {
            data = data.deleteCharAt(0);
        }

        if (data.length() == 0) {
            return 0;
        }

        if (data.length() > 10) {
            if (flag.equals("-")) {
                return -2147483648;
            } else {
                return 2147483647;
            }
        }

        long num = Long.valueOf(flag + data.toString());
        if (num > 2147483647) {
            return 2147483647;
        }

        if (num < -2147483648) {
            return -2147483648;
        }

        return (int)num;
    }
}
