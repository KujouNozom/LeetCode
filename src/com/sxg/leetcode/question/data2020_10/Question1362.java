package com.sxg.leetcode.question.data2020_10;

/**
 * @ClassName: com.sxg.leetcode.question.date2020_10.Question1362
 * @Author: Su_N
 * @Date: 2020/10/22 22:41
 * @Description: 只需要根据根号之后，向下遍历即可
 * 1362. 最接近的因数
 *
 * 给你一个整数 num，请你找出同时满足下面全部要求的两个整数：
 *
 * 两数乘积等于  num + 1 或 num + 2
 * 以绝对差进行度量，两数大小最接近
 *
 * 你可以按任意顺序返回这两个整数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：num = 8
 * 输出：[3,3]
 * 解释：对于 num + 1 = 9，最接近的两个因数是 3 & 3；对于 num + 2 = 10, 最接近的两个因数是 2 & 5，因此返回 3 & 3 。
 *
 * 示例 2：
 *
 * 输入：num = 123
 * 输出：[5,25]
 *
 * 示例 3：
 *
 * 输入：num = 999
 * 输出：[40,25]
 */
public class Question1362 {
    public int[] closestDivisors(int num) {
        int i = (int) Math.sqrt(num + 2);
        for (int index = i; index >= 0; index--) {
            if ((num + 1) % index == 0) {
                return new int[]{index, (num + 1) / index};
            }
            if ((num + 2) % index == 0) {
                return new int[]{index, (num + 2) / index};
            }
        }

        return new int[]{-1, -1};
    }
}
