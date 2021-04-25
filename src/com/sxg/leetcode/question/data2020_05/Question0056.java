package com.sxg.leetcode.question.data2020_05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Question0056
 * @Author: Su_N
 * @Date: 2020/5/2 20:17
 * @Description: 56. 合并区间 [排序然后遍历]
 */
public class Question0056 {
    public static void main(String[] args) {
        Question0056 demo = new Question0056();
        int[][] datas = new int[][] {{15, 18}, {8, 15}, {1, 3}, {2, 6}};
        int[][] rr = demo.merge(datas);

        System.out.println();
    }

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][2];
        }
        if (intervals.length == 1) {
            return intervals;
        }

        Arrays.sort(intervals, (int[] o1, int[] o2) -> o1[0] - o2[0]);

        List<int[]> resultList = new ArrayList<>();

        int[] temp = intervals[0];
        for (int index = 1; index < intervals.length; index++) {
            if (temp[1] >= intervals[index][0]) {
                temp[1] = Math.max(intervals[index][1], temp[1]);
            } else {
                resultList.add(temp);
                temp = intervals[index];
            }
        }
        resultList.add(temp);

        int[][] result = new int[resultList.size()][2];
        for (int index = 0; index < resultList.size(); index++) {
            result[index] = resultList.get(index);
        }

        return result;
    }
}
