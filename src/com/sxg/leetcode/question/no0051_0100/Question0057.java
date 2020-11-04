package com.sxg.leetcode.question.no0051_0100;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName: Question0057
 * @Author: Su_N
 * @Date: 2020/11/4 21:56
 * @Description: 模拟
 * 遍历，
 * 当插入区间的左边界大于当前节点的右节点的时候，不想交，当前节点加入到结果
 * 当插入区间的左边界小于右边界，相交，合并区间
 * 当插入边界的右边界小于当前左边界的时候，后面的都不想交，加入到结果
 * 57. 插入区间
 *
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 *
 * 示例 2：
 *
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 *
 *
 *
 * 注意：输入类型已在 2019 年 4 月 15 日更改。请重置为默认代码定义以获取新的方法签名。
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
                tempAns.add(new int[]{left, right});
                break;
            } else {
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }

        if (index >= intervals.length) {
            tempAns.add(new int[]{left, right});
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
