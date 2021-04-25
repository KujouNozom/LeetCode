package com.sxg.leetcode.question.data2020_0x.no0401_0450;

/**
 * @ClassName: Question0402
 * @Author: Su_N
 * @Date: 2020/7/29 22:18
 * @Description: 递归，计算前k+1个数字最小的一个（多个取第一个），移除这个数字前面的n个数字；继续执行这一步 k = k-n 个数字，直到k为0
 *
 * 402. 移掉K位数字
 *
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 *
 * 注意:
 *
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 *
 * 示例 1 :
 *
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 *
 * 示例 2 :
 *
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 *
 * 示例 3 :
 *
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 */
public class Question0402 {
    public static void main(String[] args) {
        Question0402 demo = new Question0402();
        System.out.println(demo.removeKdigits("10", 2));
    }

    public String removeKdigits(String num, int k) {
        StringBuilder answer = new StringBuilder("0");
        while (k > 0) {
            if (num.length() == k) {
                num = "";
                break;
            }

            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int index = 0; index <= k && index < num.length(); index++) {
                int temp = num.charAt(index) - 48;
                if (min > temp) {
                    min = temp;
                    minIndex = index;
                }
            }

            k = k - minIndex;
            answer.append(num.charAt(minIndex));
            num = num.substring(minIndex + 1);
        }

        answer.append(num);

        while (answer.length() > 0 && answer.charAt(0) == '0') {
            answer = answer.deleteCharAt(0);
        }
        return answer.length() == 0 ? "0" : answer.toString();
    }
}
