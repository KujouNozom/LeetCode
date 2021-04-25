package com.sxg.leetcode.question.data2020_04;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName: Question0006
 * @Author: Su_N
 * @Date: 2020/4/26 23:30
 * @Description: 6. Z 字形变换
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
