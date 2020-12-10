package com.sxg.leetcode.question;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName: Question1499
 * @Author: Su_N
 * @Date: 2020/12/10 23:11
 * @Description: 单调队列
 * yi + yj + |xi - xj| = xj + yj + (yi - xi),我们只需要遍历的时候，找到前面最大的满足 |xi - xj| <= k  的 yi - xi
 * 我们可以使用一个单调队列（单调递减，头部是最大）来存储已经遍历的值，每次从头部取一个元素，如果 不满足 |xi - xj| <= k，就去掉，然后继续取
 * 1499. 满足不等式的最大值
 * 困难
 * 给你一个数组 points 和一个整数 k 。数组中每个元素都表示二维平面上的点的坐标，并按照横坐标 x 的值从小到大排序。也就是说 points[i] = [xi, yi] ，并且在 1 <= i < j <= points.length 的前提下， xi < xj 总成立。
 * 请你找出 yi + yj + |xi - xj| 的 最大值，其中 |xi - xj| <= k 且 1 <= i < j <= points.length。
 * 题目测试数据保证至少存在一对能够满足 |xi - xj| <= k 的点。
 *
 * 示例 1：
 * 输入：points = [[1,3],[2,0],[5,10],[6,-10]], k = 1
 * 输出：4
 * 解释：前两个点满足 |xi - xj| <= 1 ，代入方程计算，则得到值 3 + 0 + |1 - 2| = 4 。第三个和第四个点也满足条件，得到值 10 + -10 + |5 - 6| = 1 。
 * 没有其他满足条件的点，所以返回 4 和 1 中最大的那个。
 *
 * 示例 2：
 * 输入：points = [[0,0],[3,0],[9,2]], k = 3
 * 输出：3
 * 解释：只有前两个点满足 |xi - xj| <= 3 ，代入方程后得到值 0 + 0 + |0 - 3| = 3 。
 *
 * 提示：
 * 2 <= points.length <= 10^5
 * points[i].length == 2
 * -10^8 <= points[i][0], points[i][1] <= 10^8
 * 0 <= k <= 2 * 10^8
 * 对于所有的1 <= i < j <= points.length ，points[i][0] < points[j][0] 都成立。也就是说，xi 是严格递增的。
 */
public class Question1499 {
    public int findMaxValueOfEquation(int[][] points, int k) {
        PriorityQueue<Pair> queue = new PriorityQueue(new MyComparable());
        queue.offer(new Pair(points[0][0], points[0][1] - points[0][0]));
        int ans = Integer.MIN_VALUE;

        for (int index = 1; index < points.length; index++) {
            while (!queue.isEmpty() && (points[index][0] - queue.peek().key) > k) {
                queue.poll();
            }

            if (!queue.isEmpty()) {
                ans = Math.max(ans, points[index][0] + points[index][1] + queue.peek().value);
            }

            queue.offer(new Pair(points[index][0], points[index][1] - points[index][0]));
        }

        return ans;
    }


}

class MyComparable implements Comparator<Pair> {
    @Override
    public int compare(Pair o1, Pair o2) {
        return o2.value - o1.value;
    }
}

class Pair {
    public int key;

    public int value;

    public Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
