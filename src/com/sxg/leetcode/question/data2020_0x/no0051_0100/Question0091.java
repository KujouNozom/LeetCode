package com.sxg.leetcode.question.data2020_0x.no0051_0100;

/**
 * @ClassName: Question0091
 * @Author: Su_N
 * @Date: 2020/5/18 18:18
 * @Description: 动态规划
 * 根据 f(x-1) 的最后一位m, 和新加入的 n，推导出f(x)有多少中组合(x>2)
 * 根据情况可以分为下面这些情况
 * 1.m = 0,n = 0：无解,m可以和前面组合，但是n不管和前后都无法组合
 * 2.m = 0,n != 0：f(x) = f(x-1),m必须和前面的组合，n单独一个
 * 3.m != 0,n = 0,mn可以组合：f(x) = f(x-2),n必须和m组合，
 * 4.m != 0,n = 0,mn不可以组合：无解,n不能组合,也不能单独
 * 5.m != 0,n != 0,mn可以组合：f(x) = f(x-2) + f(x-1),mn组合的时候f(x-2),mn不组合的时候f(x-1)
 * 6.m != 0,n != 0,mn不能组合：f(x-1),n单独一个
 * <p>
 * 所以先要获取前两个字符的组合情况，再推断后面的组合情况
 * <p>
 * 91. 解码方法
 * <p>
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * <p>
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * <p>
 * 示例 2:
 * <p>
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 */
public class Question0091 {
    public static void main(String[] args) {
        String s = "1320";
        for (char ss : s.toCharArray()) {
            System.out.println(Integer.valueOf(ss) - 48);
        }
    }

    public int numDecodings(String s) {
        int fx1 = 1;
        int fx2 = 0;

        int fx = 0;
        int m = 0;
        for (char c : s.toCharArray()) {
            int n = Integer.valueOf(c) - 48;

            if (m == 0) {
                if (n == 0) {
                    return 0;
                } else {
                    fx = fx1;
                }
            } else {
                if (n == 0) {
                    if (1 <= m && m <= 2) {
                        fx = fx2;
                    } else {
                        return 0;
                    }

                } else {
                    if (0 < m * 10 + n && m * 10 + n <= 26) {
                        fx = fx2 + fx1;
                    } else {
                        fx = fx1;
                    }
                }
            }

            fx2 = fx1;
            fx1 = fx;
            m = n;
        }

        return fx;
    }
}
