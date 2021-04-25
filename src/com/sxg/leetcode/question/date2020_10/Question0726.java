package com.sxg.leetcode.question.date2020_10;

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: com.sxg.leetcode.question.date2020_10.Question0726
 * @Author: Su_N
 * @Date: 2020/10/21 22:05
 * @Description: 栈
 * 读到(的时候入栈一个Map，后续的操作直到)之前都对这个Map操作，读到)之后读取系数，对栈顶元素乘以系数
 * 读取到字母的时候栈顶元素添加这个原子个数
 *
 * 726. 原子的数量
 *
 * 给定一个化学式formula（作为字符串），返回每种原子的数量。
 *
 * 原子总是以一个大写字母开始，接着跟随0个或任意个小写字母，表示原子的名字。
 *
 * 如果数量大于 1，原子后会跟着数字表示原子的数量。如果数量等于 1 则不会跟数字。例如，H2O 和 H2O2 是可行的，但 H1O2 这个表达是不可行的。
 *
 * 两个化学式连在一起是新的化学式。例如 H2O2He3Mg4 也是化学式。
 *
 * 一个括号中的化学式和数字（可选择性添加）也是化学式。例如 (H2O2) 和 (H2O2)3 是化学式。
 *
 * 给定一个化学式，输出所有原子的数量。格式为：第一个（按字典序）原子的名子，跟着它的数量（如果数量大于 1），然后是第二个原子的名字（按字典序），跟着它的数量（如果数量大于 1），以此类推。
 *
 * 示例 1:
 *
 * 输入:
 * formula = "H2O"
 * 输出: "H2O"
 * 解释:
 * 原子的数量是 {'H': 2, 'O': 1}。
 *
 * 示例 2:
 *
 * 输入:
 * formula = "Mg(OH)2"
 * 输出: "H2MgO2"
 * 解释:
 * 原子的数量是 {'H': 2, 'Mg': 1, 'O': 2}。
 *
 * 示例 3:
 *
 * 输入:
 * formula = "K4(ON(SO3)2)2"
 * 输出: "K4N2O14S4"
 * 解释:
 * 原子的数量是 {'K': 4, 'N': 2, 'O': 14, 'S': 4}。
 *
 * 注意:
 *
 * 所有原子的第一个字母为大写，剩余字母都是小写。
 * formula的长度在[1, 1000]之间。
 * formula只包含字母、数字和圆括号，并且题目中给定的是合法的化学式。
 */
public class Question0726 {
    public static void main(String[] args) {
        new Question0726().countOfAtoms("K4(ON(SO3)2)2");
    }

    private Pattern pattern = Pattern.compile("([A-Z][a-z]*)(\\d*)");

    private int i;

    public String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        stack.push(new TreeMap<>());
        i = 0;

        while (i < formula.length()) {
            if (formula.charAt(i) == '(') {
                stack.push(new TreeMap<>());
                i++;
            } else if (formula.charAt(i) == ')') {
                int start = ++i;
                while (i < formula.length() && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                String numString = formula.substring(start, i);
                int num = numString.isEmpty() ? 1 : Integer.valueOf(numString);
                Map<String, Integer> counts = stack.pop();
                Map<String, Integer> current = stack.peek();
                for (Map.Entry<String, Integer> temp : counts.entrySet()) {
                    String key = temp.getKey();
                    current.put(key, current.getOrDefault(key, 0) + temp.getValue() * num);
                }
            } else {
                int start = i;
                i = i + 1;
                while (i < formula.length() && formula.charAt(i) != '(' && formula.charAt(i) != ')') {
                    i++;
                }
                String dataString = formula.substring(start, i);
                Map<String, Integer> counts = getCounts(dataString);
                Map<String, Integer> current = stack.peek();
                for (Map.Entry<String, Integer> temp : counts.entrySet()) {
                    String key = temp.getKey();
                    current.put(key, current.getOrDefault(key, 0) + temp.getValue());
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        Map<String, Integer> current = stack.pop();
        for (Map.Entry<String, Integer> temp : current.entrySet()) {
            ans.append(temp.getKey()).append(temp.getValue() == 1 ? "" : temp.getValue());
        }
        return ans.toString();
    }


    private Map<String, Integer> getCounts(String data) {
        Matcher matcher = pattern.matcher(data);
        Map<String, Integer> counts = new TreeMap<>();
        while (matcher.find()) {
            String key = matcher.group(1);
            String valueString = matcher.group(2);
            int value = valueString.isEmpty() ? 1 : Integer.parseInt(valueString);
            counts.put(key, counts.getOrDefault(key, 0) + value);
        }
        return counts;
    }

}
