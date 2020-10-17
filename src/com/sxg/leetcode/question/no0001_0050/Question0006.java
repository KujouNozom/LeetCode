package com.sxg.leetcode.question.no0001_0050;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName: Question0006
 * @Author: Su_N
 * @Date: 2020/4/26 23:30
 * @Description: 6. Z 字形变换
 * <p>
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * <p>
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * <p>
 * 示例 2:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * <p>
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 */
public class Question0006 {
    public static void main(String[] args) {
        Question0006 demo = new Question0006();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            System.out.println(demo.convert(scanner.nextLine(), Integer.valueOf(scanner.nextLine())));
        }
        scanner.close();
    }

    public String convert(String s, int numRows) {
        if (numRows == 0 || s == null || s.isEmpty()) {
            return "";
        }

        if (numRows == 1) {
            return s;
        }

        boolean direction = true;
        Map<Integer, StringBuilder> levelMap = new HashMap<>();
        for (int level = 0; level < numRows; level++) {
            levelMap.put(level, new StringBuilder());
        }

        int currentLevel = 0;
        for (int index = 0; index < s.length(); index++) {
            levelMap.get(currentLevel).append(s.charAt(index));
            if (direction) {
                currentLevel++;
            } else {
                currentLevel--;
            }

            if (currentLevel == 0 || currentLevel == numRows - 1) {
                direction = !direction;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int level = 0; level < numRows; level++) {
            result.append(levelMap.get(level));
        }

        return result.toString();
    }
}
