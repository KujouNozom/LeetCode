package com.sxg.leetcode.question.data2021_05;

/**
 * @ClassName: Question0050
 * @Author: Su_N
 * @Date: 2020/5/6 19:32
 * @Description: 50. Pow(x, n)
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
