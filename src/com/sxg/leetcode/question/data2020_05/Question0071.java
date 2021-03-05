package com.sxg.leetcode.question.data2020_05;

import java.util.Stack;

/**
 * @ClassName: Question0071
 * @Author: Su_N
 * @Date: 2020/5/22 8:32
 * @Description: 71. 简化路径 [栈，模拟]
 */
public class Question0071 {
    public String simplifyPath(String path) {
        String[] dirs = path.split("/");
        Stack<String> stack = new Stack<String>();
        for (String dir : dirs) {
            if (dir.equals("") || dir.equals(".")) {
                continue;
            }

            if (dir.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                continue;
            }

            stack.push(dir);
        }

        String[] results = new String[stack.size()];
        stack.toArray(results);

        return "/" + String.join("/", results);
    }
}
