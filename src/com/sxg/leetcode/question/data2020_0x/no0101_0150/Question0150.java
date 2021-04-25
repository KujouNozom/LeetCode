package com.sxg.leetcode.question.data2020_0x.no0101_0150;

import java.util.Stack;
import java.util.regex.Pattern;

/**
 * @ClassName: Question0150
 * @Author: Su_N
 * @Date: 2020/6/11 23:42
 * @Description: 使用堆栈
 * 遇到数字入栈，遇到符号，出栈两个元素计算，然后结果入栈
 * <p>
 * 150. 逆波兰表达式求值
 * <p>
 * 根据逆波兰表示法，求表达式的值。
 * <p>
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * <p>
 * 说明：
 * <p>
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * <p>
 * 示例 1：
 * <p>
 * 输入: ["2", "1", "+", "3", "*"]
 * 输出: 9
 * 解释: ((2 + 1) * 3) = 9
 * <p>
 * 示例 2：
 * <p>
 * 输入: ["4", "13", "5", "/", "+"]
 * 输出: 6
 * 解释: (4 + (13 / 5)) = 6
 * <p>
 * 示例 3：
 * <p>
 * 输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * 输出: 22
 * 解释:
 * ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 * <p>
 * 通过次数40,849
 * 提交次数81,224
 */
public class Question0150 {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        Pattern flagPattern = Pattern.compile("[/+-/*//]{1}");

        for (String temp : tokens) {
            if (flagPattern.matcher(temp).matches()) {
                String b = stack.pop();
                String a = stack.pop();
                int result = calc(Integer.valueOf(a), Integer.valueOf(b), temp);
                stack.push(String.valueOf(result));
            } else {
                stack.push(temp);
            }
        }


        return Integer.valueOf(stack.pop());
    }

    private int calc(int a, int b, String calc) {
        switch (calc) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                return 0;
        }
    }
}
