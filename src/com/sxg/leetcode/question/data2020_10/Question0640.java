package com.sxg.leetcode.question.data2020_10;

/**
 * @ClassName: com.sxg.leetcode.question.date2020_10.Question0640
 * @Author: Su_N
 * @Date: 2020/10/30 20:38
 * @Description: 移项，x 放到左边，常数放到右边，计数
 * 640. 求解方程
 *
 * 求解一个给定的方程，将x以字符串"x=#value"的形式返回。该方程仅包含'+'，' - '操作，变量 x 和其对应系数。
 *
 * 如果方程没有解，请返回“No solution”。
 *
 * 如果方程有无限解，则返回“Infinite solutions”。
 *
 * 如果方程中只有一个解，要保证返回值 x 是一个整数。
 *
 * 示例 1：
 *
 * 输入: "x+5-3+x=6+x-2"
 * 输出: "x=2"
 *
 * 示例 2:
 *
 * 输入: "x=x"
 * 输出: "Infinite solutions"
 *
 * 示例 3:
 *
 * 输入: "2x=x"
 * 输出: "x=0"
 *
 * 示例 4:
 *
 * 输入: "2x+3x-6x=x+2"
 * 输出: "x=-1"
 *
 * 示例 5:
 *
 * 输入: "x=x+2"
 * 输出: "No solution"
 */
public class Question0640 {
    public static void main(String[] args) {
        new Question0640().solveEquation("-x=-1");
    }

    public String solveEquation(String equation) {
        equation = equation.replaceAll("-", "+-");
        String[] equations = equation.split("=");
        int xCount = 0;
        int numCount = 0;

        String[] leftNums = equations[0].split("\\+");
        for (String leftNum : leftNums) {
            if (!leftNum.isEmpty()) {
                if (leftNum.endsWith("x")) {
                    xCount += getCount(leftNum.substring(0, leftNum.length() - 1));
                } else {
                    numCount -= Integer.parseInt(leftNum);
                }
            }
        }

        String[] rightNums = equations[1].split("\\+");
        for (String rightNum : rightNums) {
            if (!rightNum.isEmpty()) {
                if (rightNum.endsWith("x")) {
                    xCount -= getCount(rightNum.substring(0, rightNum.length() - 1));
                } else {
                    numCount += Integer.parseInt(rightNum);
                }
            }
        }


        if (xCount == 0 && numCount == 0) {
            return "Infinite solutions";
        }
        if (xCount == 0) {
            return "No solution";
        }
        return "x=" + numCount / xCount;
    }


    private int getCount(String num) {
        if (num.length() == 0) {
            return 1;
        }

        if (num.equals("-")) {
            return -1;
        }

        return Integer.valueOf(num);
    }
}
