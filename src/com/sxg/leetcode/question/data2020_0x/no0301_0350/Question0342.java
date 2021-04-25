package com.sxg.leetcode.question.data2020_0x.no0301_0350;

/**
 * @ClassName: Question0342
 * @Author: Su_N
 * @Date: 2020/10/26 23:00
 * @Description: 利用性质 x & (x - 1) == 0 是2 的幂（因为2的幂二进制都是一个1，后面全是0）
 * 我们类似的可以发现，2的偶数幂1在奇数位置，奇数幂1在偶数位置
 * 我们通过和偶数位置全部是1，奇数位置全部是0的二进制（-1431655766）与，得到0的话说明1在奇数位置
 *
 * 342. 4的幂
 *
 * 给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 16
 * 输出: true
 *
 * 示例 2:
 *
 * 输入: 5
 * 输出: false
 *
 * 进阶：
 * 你能不使用循环或者递归来完成本题吗？
 */
public class Question0342 {
    public boolean isPowerOfFour(int num) {
        return (num > 0) && ((num & (num - 1)) == 0) && ((num & -1431655766) == 0);
    }
}
