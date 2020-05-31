package com.sxg.leetcode.finished.no0001_0050;

/**
 * @ClassName: Question0050
 * @Author: Su_N
 * @Date: 2020/5/6 19:32
 * @Description: 注意 n= -2147483648的时候转换成正数会超出范围，需要使用long接受
 * 50. Pow(x, n)
 * <p>
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * <p>
 * 示例 2:
 * <p>
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * <p>
 * 示例 3:
 * <p>
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * <p>
 * 说明:
 * <p>
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 */
public class Question0050 {
    public static void main(String[] args) {
        Question0050 demo = new Question0050();
        demo.myPow(2.00000, 10);
    }

    public double myPow(double x, int n) {
        long nl = n;
        if (nl == 0) {
            return 1;
        }

        if (nl < 0) {
            nl = -n;
            x = 1 / x;
        }

        double tempMi = x;
        double retult = 1;
        long index = nl;
        while (index > 0) {
            if (index % 2 == 1) {
                retult = retult * tempMi;
            }
            tempMi = tempMi * tempMi;
            index /= 2;
        }


        return retult;
    }
}
