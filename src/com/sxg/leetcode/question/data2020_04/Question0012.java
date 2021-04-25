package com.sxg.leetcode.question.data2020_04;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName: Question0012
 * @Author: Su_N
 * @Date: 2020/4/27 20:40
 * @Description: 12. 整数转罗马数字
 */
public class Question0012 {
    public static Map<Integer, String> convertMap = new LinkedHashMap<>();

    static {
        convertMap.put(1000, "M");
        convertMap.put(900, "CM");
        convertMap.put(500, "D");
        convertMap.put(400, "CD");
        convertMap.put(100, "C");
        convertMap.put(90, "XC");
        convertMap.put(50, "L");
        convertMap.put(40, "XL");
        convertMap.put(10, "X");
        convertMap.put(9, "IX");
        convertMap.put(5, "V");
        convertMap.put(4, "IV");
        convertMap.put(1, "I");
    }

    public static void main(String[] args) {
        Question0012 demo = new Question0012();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            System.out.println(demo.intToRoman(Integer.valueOf(scanner.nextLine())));
        }
        scanner.close();
    }

    public String intToRoman(int num) {
        if (num == 0) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        for (Map.Entry<Integer, String> temp : convertMap.entrySet()) {
            int key = temp.getKey();
            String value = temp.getValue();

            int count = num / key;
            for (int index = 0; index < count; index++) {
                result.append(value);
            }

            num = num % key;
        }

        return result.toString();
    }
}
