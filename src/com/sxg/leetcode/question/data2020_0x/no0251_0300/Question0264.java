package com.sxg.leetcode.question.data2020_0x.no0251_0300;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Question0264
 * @Author: Su_N
 * @Date: 2020/7/8 21:52
 * @Description: 三指针
 * 一个丑数肯定是另一个丑数乘以2/3/5，因此我们可以初始化一个包含1的集合，每次从集合中取出任意一个数乘以2/3/5，取最小的一个数字加入集合
 *
 * 使用三个指针分别指向，当前结果集合中还没有和 2或者3或者5 相乘的最小丑数（因为大于这个数的丑数和对应因子相乘肯定不是最小的）
 * 三个乘积中最小的一个加入集合，移动对应因子的指针指向下一个数
 *
 * PS：因为告诉我们了范围，可以初始化这个范围内的所有丑数，每次访问的时候直接获取结果（不知道用例多不多，这种方式用例越多越省时间）
 *
 * 264. 丑数 II
 *
 * 编写一个程序，找出第 n 个丑数。
 *
 * 丑数就是质因数只包含 2, 3, 5 的正整数。
 *
 * 示例:
 *
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 *
 * 说明:
 *
 * 1 是丑数。
 * n 不超过1690。
 */
public class Question0264 {

    public static void main(String[] args) {
        System.out.println();
    }

    private static List<Integer> nums = new ArrayList<>();

    static {
        nums.add(1);
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        int result2;
        int result3;
        int result5;

        for (int index = 1; index < 1690; index++) {
            result2 = nums.get(index2) * 2;
            result3 = nums.get(index3) * 3;
            result5 = nums.get(index5) * 5;

            int result = Math.min(Math.min(result2, result3), result5);
            nums.add(result);

            if (result2 == result) {
                index2++;
            }
            if (result3 == result) {
                index3++;
            }
            if (result5 == result) {
                index5++;
            }
        }
    }

    public int nthUglyNumber(int n) {
        if (n <= 0) {
            return -1;
        }

        return nums.get(n - 1);
    }
}

