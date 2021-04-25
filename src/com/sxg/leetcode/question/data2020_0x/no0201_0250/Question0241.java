package com.sxg.leetcode.question.data2020_0x.no0201_0250;

import java.util.*;

/**
 * @ClassName: Question0241
 * @Author: Su_N
 * @Date: 2020/7/7 22:33
 * @Description: 动态规划
 * f(i,j)表示从i到j右多少中不同的结果，使用一个List[][]数组存储结果集合
 * ij相差0的时候就是本身，相差1的时候就是直接计算的结果
 * 相差（l）2及以上的时候，可以拆分为两部分，f(i,i+l/2-1) 和 f(i+l/2,j) 两个数组里面的数字笛卡尔积，通过两部分中间的符号计算
 *
 * 我们从相差1开始一直推到相差length-1 得到最终结果
 *
 * 注意：写代码的时候发现，使用两个数组存储值和符号更方便
 *
 *
 * 241. 为运算表达式设计优先级
 *
 * 给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。
 *
 * 示例 1:
 *
 * 输入: "2-1-1"
 * 输出: [0, 2]
 * 解释:
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 *
 * 示例 2:
 *
 * 输入: "2*3-4*5"
 * 输出: [-34, -14, -10, -10, 10]
 * 解释:
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 */
public class Question0241 {
    public static void main(String[] args) {
        Question0241 demo = new Question0241();
        System.out.println(demo.diffWaysToCompute("2-1-1"));
    }

    private Set<Character> options = new HashSet<>(Arrays.asList('+', '-', '*'));

    public List<Integer> diffWaysToCompute(String input) {
        if (input == null || input.length() == 0) {
            return new ArrayList();
        }

        List<Integer> nums = new ArrayList<>();
        List<Character> symbols = new ArrayList<>();
        initNumsAndSymbols(input, nums, symbols);
        List<Integer>[][] dp = initDP(nums);

        for (int l = 1; l < nums.size(); l++) {
            for (int index = 0; index + l < nums.size(); index++) {
                int end = index + l;
                List<Integer> result = new ArrayList<>();
                for (int k = index; k < end; k++) {
                    char symbol = symbols.get(k);
                    List<Integer> numsA = dp[index][k];
                    List<Integer> numsB = dp[k + 1][end];
                    result.addAll(getDp(symbol, numsA, numsB));
                }
                dp[index][end] = result;
            }
        }

        return dp[0][nums.size() - 1];
    }

    private List<Integer> getDp(char symbol, List<Integer> numsA, List<Integer> numsB) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < numsA.size(); i++) {
            for (int j = 0; j < numsB.size(); j++) {
                result.add(cal(numsA.get(i), numsB.get(j), symbol));
            }
        }
        return result;
    }

    private List<Integer>[][] initDP(List<Integer> nums) {
        List<Integer>[][] dp = new List[nums.size()][nums.size()];
        for (int index = 0; index < nums.size(); index++) {
            List<Integer> temp0 = new ArrayList<>();
            temp0.add(nums.get(index));
            dp[index][index] = temp0;
        }
        return dp;
    }

    private void initNumsAndSymbols(String input, List<Integer> nums, List<Character> symbols) {
        int num = 0;
        for (int i = 0; i < input.length(); i++) {
            if (options.contains(input.charAt(i))) {
                symbols.add(input.charAt(i));
                nums.add(num);
                num = 0;
            } else {
                num = num * 10 + (Integer.valueOf(input.charAt(i)) - 48);
            }
        }
        nums.add(num);
    }

    private Integer cal(int a, int b, char symbol) {
        switch (symbol) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            default:
                return 0;
        }
    }
}
