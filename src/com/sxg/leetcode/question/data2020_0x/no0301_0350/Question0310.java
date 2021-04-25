package com.sxg.leetcode.question.data2020_0x.no0301_0350;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: Question0310
 * @Author: Su_N
 * @Date: 2020/7/17 21:15
 * @Description: 将所有节点中的叶子节点删除，剩下的就是内一层的节点，再将剩下节点的叶子节点都删除就是更内一层的节点，直到剩下的节点都是叶子节点
 *
 *
 *
 * 310. 最小高度树
 *
 * 对于一个具有树特征的无向图，我们可选择任何一个节点作为根。图因此可以成为树，在所有可能的树中，具有最小高度的树被称为最小高度树。给出这样的一个图，写出一个函数找到所有的最小高度树并返回他们的根节点。
 *
 * 格式
 *
 * 该图包含 n 个节点，标记为 0 到 n - 1。给定数字 n 和一个无向边 edges 列表（每一个边都是一对标签）。
 *
 * 你可以假设没有重复的边会出现在 edges 中。由于所有的边都是无向边， [0, 1]和 [1, 0] 是相同的，因此不会同时出现在 edges 里。
 *
 * 示例 1:
 *
 * 输入: n = 4, edges = [[1, 0], [1, 2], [1, 3]]
 *
 * 0
 * |
 * 1
 * / \
 * 2   3
 *
 * 输出: [1]
 *
 * 示例 2:
 *
 * 输入: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
 *
 * 0  1  2
 * \ | /
 * 3
 * |
 * 4
 * |
 * 5
 *
 * 输出: [3, 4]
 *
 * 说明:
 *
 * 根据树的定义，树是一个无向图，其中任何两个顶点只通过一条路径连接。 换句话说，一个任何没有简单环路的连通图都是一棵树。
 * 树的高度是指根节点和叶子节点之间最长向下路径上边的数量。
 */
public class Question0310 {
    public static void main(String[] args) {
        Question0310 demo = new Question0310();
        demo.findMinHeightTrees(6, new int[][]{{0, 1}, {0, 2}, {0, 3}, {3, 4}, {4, 5}});
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 0 || edges == null || edges.length == 0) {
            List<Integer> answer = new ArrayList<>();
            answer.add(0);
            return answer;
        }

        Map<Integer, List<Integer>> sides = new HashMap<>(n);
        Map<Integer, Integer> nodeCounts = new HashMap<>(n);
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            buildSides(sides, b, a);
            buildSides(sides, a, b);

            nodeCounts.put(a, nodeCounts.get(a) == null ? 1 : nodeCounts.get(a) + 1);
            nodeCounts.put(b, nodeCounts.get(b) == null ? 1 : nodeCounts.get(b) + 1);
        }


        while (!nodeCounts.isEmpty()) {
            List<Integer> answer = new ArrayList<>();

            nodeCounts.forEach((k, v) -> {
                if (v <= 1) {
                    answer.add(k);
                }
            });

            if (nodeCounts.size() == answer.size()) {
                return answer;
            }

            answer.forEach(k -> {
                sides.get(k).forEach(j -> {
                    sides.get(j).remove(k);
                    nodeCounts.put(j, nodeCounts.get(j) - 1);

                });
                nodeCounts.remove(k);
                sides.remove(k);
            });
        }

        return new ArrayList<>();
    }

    private void buildSides(Map<Integer, List<Integer>> sides, int a, int b) {
        List tempb = sides.get(b);
        if (tempb == null) {
            tempb = new ArrayList();
            sides.put(b, tempb);
        }
        tempb.add(a);
    }
}
