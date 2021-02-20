package com.sxg.leetcode.question.data2020_0x.no0401_0450;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName: Question0436
 * @Author: Su_N
 * @Date: 2020/8/10 20:32
 * @Description: 436. 寻找右区间
 *
 * 给定一组区间，对于每一个区间 i，检查是否存在一个区间 j，它的起始点大于或等于区间 i 的终点，这可以称为 j 在 i 的“右侧”。
 *
 * 对于任何区间，你需要存储的满足条件的区间 j 的最小索引，这意味着区间 j 有最小的起始点可以使其成为“右侧”区间。如果区间 j 不存在，则将区间 i 存储为 -1。最后，你需要输出一个值为存储的区间值的数组。
 *
 * 注意:
 *
 * 你可以假设区间的终点总是大于它的起始点。
 * 你可以假定这些区间都不具有相同的起始点。
 *
 * 示例 1:
 *
 * 输入: [ [1,2] ]
 * 输出: [-1]
 *
 * 解释:集合中只有一个区间，所以输出-1。
 *
 * 示例 2:
 *
 * 输入: [ [3,4], [2,3], [1,2] ]
 * 输出: [-1, 0, 1]
 *
 * 解释:对于[3,4]，没有满足条件的“右侧”区间。
 * 对于[2,3]，区间[3,4]具有最小的“右”起点;
 * 对于[1,2]，区间[2,3]具有最小的“右”起点。
 *
 * 示例 3:
 *
 * 输入: [ [1,4], [2,3], [3,4] ]
 * 输出: [-1, 2, -1]
 *
 * 解释:对于区间[1,4]和[3,4]，没有满足条件的“右侧”区间。
 * 对于[2,3]，区间[3,4]有最小的“右”起点。
 */
public class Question0436 {
    public int[] findRightInterval(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0];
        }

        int length = intervals.length;

        Node[] startIndexes = new Node[length];
        Node[] endIndexes = new Node[length];
        for (int index = 0; index < length; index++) {
            Node node = new Node(index, intervals[index][0], intervals[index][1]);
            startIndexes[index] = node;
            endIndexes[index] = node;
        }
        Arrays.sort(startIndexes, Comparator.comparing(node -> node.start));
        Arrays.sort(endIndexes, Comparator.comparing(node -> node.end));

        int[] answer = new int[length];
        int startIndex = 0;

        for (Node endNode : endIndexes) {
            int endValue = endNode.end;
            while (startIndex < length && endValue > startIndexes[startIndex].start) {
                startIndex++;
            }

            if (startIndex < length && startIndex != 0) {
                answer[endNode.index] = startIndexes[startIndex].index;
            } else {
                answer[endNode.index] = -1;
            }
        }
        return answer;
    }

    class Node {
        public Node(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }

        public int index;

        public int start;

        public int end;
    }
}


