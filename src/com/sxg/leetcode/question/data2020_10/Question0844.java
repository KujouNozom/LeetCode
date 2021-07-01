package com.sxg.leetcode.question.data2020_10;

import java.util.Stack;

/**
 * @ClassName: Question0844
 * @Author: Su_N
 * @Date: 2020/10/19 22:25
 * @Description: 堆栈
 * 使用两个栈，当遇到 # 的时候出栈一个字符（如果栈为空不操作），否则入栈字符。
 * 最后比较两个栈
 */
public class Question0844 {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();

        rebuildString(S, stackS);
        rebuildString(T, stackT);

        return stackS.equals(stackT);
    }

    private void rebuildString(String S, Stack<Character> stackS) {
        for (char temp : S.toCharArray()) {
            if (temp == '#') {
                if (!stackS.isEmpty()) {
                    stackS.pop();
                }
            } else {
                stackS.push(temp);
            }
        }
    }
}
