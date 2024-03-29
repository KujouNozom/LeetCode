package com.sxg.leetcode.question.data2020_10;

/**
 * @ClassName: Question1551
 * @Author: Su_N
 * @Date: 2020/10/29 22:19
 * @Description: 分类讨论
 * 数组长度奇数的时候，最终值是中间的数，左右各有k个数字需要变化，k = arr.length/2
 * 左右第一个数字移动 2 次，第二个 2 + 2 ...... 最后一个 2 + 2*(k-1)利用等差数列 (2 + (2 + 2*(k-1))) * k / 2
 * 同理，偶数的时候，转化数字是中间两个数字的均值，左右k个数字，移动次数(1 + (1 + 2*(k-1))) * k / 2
 * 简化为偶数k*k;奇数k*(k+1)
 *
 * 1551. 使数组中所有元素相等的最小操作数
 *
 * 存在一个长度为 n 的数组 arr ，其中 arr[i] = (2 * i) + 1 （ 0 <= i < n ）。
 *
 * 一次操作中，你可以选出两个下标，记作 x 和 y （ 0 <= x, y < n ）并使 arr[x] 减去 1 、arr[y] 加上 1 （即 arr[x] -=1 且 arr[y] += 1 ）。最终的目标是使数组中的所有元素都 相等 。题目测试用例将会 保证 ：在执行若干步操作后，数组中的所有元素最终可以全部相等。
 *
 * 给你一个整数 n，即数组的长度。请你返回使数组 arr 中所有元素相等所需的 最小操作数 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：2
 * 解释：arr = [1, 3, 5]
 * 第一次操作选出 x = 2 和 y = 0，使数组变为 [2, 3, 4]
 * 第二次操作继续选出 x = 2 和 y = 0，数组将会变成 [3, 3, 3]
 *
 * 示例 2：
 *
 * 输入：n = 6
 * 输出：9
 *
 *
 *
 * 提示：
 *
 * 1 <= n <= 10^4
 */
public class Question1551 {
    public int minOperations(int n) {
        int k = n / 2;
        return n % 2 == 0 ? (k * k) : (k * (k + 1));
    }
}
