package com.sxg.leetcode.question.data2020_0x.no0301_0350;

/**
 * @ClassName: Question0367
 * @Author: Su_N
 * @Date: 2020/10/15 22:36
 * @Description: 牛顿迭代法
 * 每次取x ,如果 x^2 > num，则下一个取值y = (num/x + x)/2;
 * 中间过程中如果存在 x^2 = num,就是最终的解，如果最接从 x^2 > num 变为 x^2 < num,说面没有解，不是一个完全平方数
 * 367. 有效的完全平方数
 *
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 *
 * 说明：不要使用任何内置的库函数，如  sqrt。
 *
 * 示例 1：
 *
 * 输入：16
 * 输出：True
 *
 * 示例 2：
 *
 * 输入：14
 * 输出：False
 */
public class Question0367 {
    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }

        long x = num / 2;
        while (x * x > num) {
            x = (num / x + x) / 2;
        }

        return x * x == num;
    }
}
