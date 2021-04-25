package com.sxg.leetcode.question.data2020_11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName: Question0057
 * @Author: Su_N
 * @Date: 2020/11/4 21:56
 * @Description: 57. 插入区间 [模拟]
 */
public class Question0057 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> tempAns = new ArrayList<>();
        int left = newInterval[0];
        int right = newInterval[1];
        int index = 0;
        for (; index < intervals.length; index++) {
            int[] interval = intervals[index];
            if (left > interval[1]) {
                tempAns.add(interval);
            } else if (right < interval[0]) {
                tempAns.add(new int[] {left, right});
                break;
            } else {
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }

        if (index >= intervals.length) {
            tempAns.add(new int[] {left, right});
        }

        int[][] ans = new int[intervals.length - index + tempAns.size()][2];
        int ansIndex = 0;
        Iterator<int[]> iterator = tempAns.iterator();
        while (iterator.hasNext()) {
            ans[ansIndex++] = iterator.next();
        }

        for (; index < intervals.length; index++) {
            ans[ansIndex++] = intervals[index];
        }

        return ans;
    }
}
