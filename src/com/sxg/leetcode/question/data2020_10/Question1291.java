package com.sxg.leetcode.question.data2020_10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName: com.sxg.leetcode.question.date2020_10.Question1291
 * @Author: Su_N
 * @Date: 2020/10/24 13:26
 * @Description: 枚举
 * 因为数字很少，可以枚举每个数字，判断是否在区间内，先枚举1开头的，在枚举2,一次类推，最后排序
 * 1291. 顺次数
 *
 * 我们定义「顺次数」为：每一位上的数字都比前一位上的数字大 1 的整数。
 *
 * 请你返回由 [low, high] 范围内所有顺次数组成的 有序 列表（从小到大排序）。
 *
 *
 *
 * 示例 1：
 *
 * 输出：low = 100, high = 300
 * 输出：[123,234]
 *
 * 示例 2：
 *
 * 输出：low = 1000, high = 13000
 * 输出：[1234,2345,3456,4567,5678,6789,12345]
 *
 *
 *
 * 提示：
 *
 * 10 <= low <= high <= 10^9
 */
public class Question1291 {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> answers = new ArrayList<>();
        for (int start = 1; start < 9; start++) {
            int num = start;
            for (int next = start + 1; next <= 9; next++) {
                num = num * 10 + next;
                if (low <= num && num <= high) {
                    answers.add(num);
                }
            }
        }
        Collections.sort(answers);
        return answers;
    }
}
