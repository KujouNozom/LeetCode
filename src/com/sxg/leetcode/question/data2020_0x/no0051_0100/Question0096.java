package com.sxg.leetcode.question.data2020_0x.no0051_0100;

/**
 * @ClassName: Question0096
 * @Author: Su_N
 * @Date: 2020/5/21 8:35
 * @Description: 动态规划，或者数学好的可以去看下 卡塔兰数
 * f(n):表示n个节点可以构成的二叉搜索树个数
 * 我们从n个节点中取出一个i当做根节点，剩下的分为两组(1,i-1)和(i+1,n),它们分别有i-1和n-i个节点
 * 这两组可以构建的二叉搜索树树的个数为f(i-1)和f(n-i-1)，它们可以组成的组合数为f(i-1)*f(n-i)
 * 所以地推公式为f(n) = sum(f(i-1)*f(n-i-1)) [1<=i<=n]
 * 初始状态为 f(0) = 1;f(1) = 1
 * <p>
 * 96. 不同的二叉搜索树
 * <p>
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 */
public class Question0096 {
    public int numTrees(int n) {
        int[] f = new int[n + 1];
        f[0] = 1;
        f[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                f[i] = f[i] + f[j - 1] * f[i - j];
            }
        }

        return f[n];
    }
}
