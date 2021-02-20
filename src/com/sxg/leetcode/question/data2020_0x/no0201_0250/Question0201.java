package com.sxg.leetcode.question.data2020_0x.no0201_0250;

/**
 * @ClassName: Question0201
 * @Author: Su_N
 * @Date: 2020/6/21 13:42
 * @Description: 右移找到公共前缀，然后左移
 * 我们会发现连续数字的区间大小超过 2^k的时候，最后边的k位就是0,1都出现的
 * 例如连续两个数组最右边一位是0，1都出现的，连续四个的话，最右边两位是0,1都出现的，因为它们去掉全面的前缀的是否数字变成 0 1 2 3
 * 我们不停的右移，左右边界的位数是最多和最少的，因为只需要右移到左右边界相等（左右边界公共前缀）的时候，再左移，补0
 * 201. 数字范围按位与
 *
 * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
 *
 * 示例 1:
 *
 * 输入: [5,7]
 * 输出: 4
 *
 * 示例 2:
 *
 * 输入: [0,1]
 * 输出: 0
 */
public class Question0201 {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == n) {
            return m;
        }

        int moveCountBase = (int) (Math.log(n - m) / Math.log(2));
        m = m >> moveCountBase;
        n = n >> moveCountBase;

        while (m < n) {
            m = m >> 1;
            n = n >> 1;
            moveCountBase++;
        }

        return n << moveCountBase;
    }
}
