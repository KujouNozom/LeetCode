package com.sxg.leetcode.question.data2020_0x.no0401_0450;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName: Question0435
 * @Author: Su_N
 * @Date: 2020/8/8 23:28
 * @Description: 贪心算法
 *
 * 按照区间起点排序，前后两个区间记做A,B,三种情况。使用一个指针指向当前区间A
 * 1.A,B无重合，移动指针到B
 * 2.A,B重合,B的终点大于等于A的终点,移除B，指针不变。因为所有情况都需要移除B
 * 列举所用情况：
 * 再下一个C的起点在A的终点之前的情况有三种，不管移除那个都需要移除至少两个
 * 再下一个C的起点在A的终点之后有两种情况，最少需要移除B
 * 再下一个C的起点在B的终点之后有以种情况，最少需要移除B
 * 3.A，B重合，B的终点在A的终点之前，移除A，这样剩下的区间更大
 *
 *
 * 435. 无重叠区间
 *
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 *
 * 注意:
 *
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 *
 * 示例 1:
 *
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 *
 * 输出: 1
 *
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 *
 * 示例 2:
 *
 * 输入: [ [1,2], [1,2], [1,2] ]
 *
 * 输出: 2
 *
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 *
 * 示例 3:
 *
 * 输入: [ [1,2], [2,3] ]
 *
 * 输出: 0
 *
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 */
public class Question0435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length != 2) {
            return 0;
        }

        if (intervals.length == 1) {
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int currentIndex = 0;
        int answer = 0;

        for (int index = 1; index < intervals.length; index++) {
            int currentEnd = intervals[currentIndex][1];
            int nextStart = intervals[index][0];
            int nextEnd = intervals[index][1];

            // 第一种情况
            if (currentEnd <= nextStart) {
                currentIndex = index;
                continue;
            }

            // 第三种情况
            if (nextEnd <= currentEnd) {
                currentIndex = index;
                answer++;
                continue;
            }

            // 第二种情况
            answer++;
        }

        return answer;
    }
}
