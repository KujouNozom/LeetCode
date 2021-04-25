package com.sxg.leetcode.question.data2020_0x.no0051_0100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName: Question0089
 * @Author: Su_N
 * @Date: 2020/5/13 19:53
 * @Description: 循环，找规则
 * 我们发现
 * n = 0：[0]
 * n = 1：[0,1]          n = 0 的结果数组[0]的每位加上2^n-1, 得到[1],反序添加到结果数组，得到[0,1]
 * n = 2：[0,1,3,2]      n = 1 的结果数组[0,1]的每位加上2^n-1, 得到[2,3],反序添加到结果数组，得到[0,1,3,2]
 * n = 3：[0,1,3,2]      n = 2 的结果数组[0,1,3,2]的每位加上2^n-1, 得到[4,5,7,6],反序添加到结果数组，得到[0,1,3,2,6,7,5,4]
 * 89. 格雷编码
 * <p>
 * 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
 * <p>
 * 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。即使有多个不同答案，你也只需要返回其中一种。
 * <p>
 * 格雷编码序列必须以 0 开头。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2
 * 输出: [0,1,3,2]
 * 解释:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * <p>
 * 对于给定的 n，其格雷编码序列并不唯一。
 * 例如，[0,2,3,1] 也是一个有效的格雷编码序列。
 * <p>
 * 00 - 0
 * 10 - 2
 * 11 - 3
 * 01 - 1
 * <p>
 * 示例 2:
 * <p>
 * 输入: 0
 * 输出: [0]
 * 解释: 我们定义格雷编码序列必须以 0 开头。
 * 给定编码总位数为 n 的格雷编码序列，其长度为 2n。当 n = 0 时，长度为 20 = 1。
 * 因此，当 n = 0 时，其格雷编码序列为 [0]。
 */
public class Question0089 {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        result.add(0);
        if (n == 0) {
            return result;
        }

        for (int index = 1; index <= n; index++) {
            List<Integer> temp = new ArrayList<>();
            int addValue = (int) Math.pow(2, index - 1);
            for (int num : result) {
                temp.add(num + addValue);
            }

            Collections.reverse(temp);
            result.addAll(temp);
        }

        return result;
    }
}
