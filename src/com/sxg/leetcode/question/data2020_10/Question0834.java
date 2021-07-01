package com.sxg.leetcode.question.data2020_10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: com.sxg.leetcode.question.date2020_10.Question0834
 * @Author: Su_N
 * @Date: 2020/10/6 12:44
 * @Description: 动态规划
 * dp[i]:表示以 i 为根节点的所有子节点到节点 i 的距离之和
 * childrenCount[i]:表示以 i 为根节点的子树（子孙节点 + 自身）数量（递归，包含自身）
 *
 * dp[i] = sum(dp[j] + childrenCount[j]),j 是 i 节点的子节点
 * dp[j] 表示了孩子节点的路径之和，但是 j 到 i 还有距离1，因此每个子孙节点到 i 的路径都会包含 j 到 i。
 * 此外 j 自身也会到 i,因此需要加上所有子树（子孙节点 + 自身）的数量
 *
 * 这是计算一个节点的过程，当我们获取了一个节点的时候，后面的节点我们可以通过这个节点推算出来
 * 例如 b 是 a 的子节点，我们调换 a 和 b,别的dp不会受到影响，只有 a 和 b 的dp会受影响
 *
 * i 变成了 b 的子节点:
 * 新的 dp[a] 需要在原来的 dp[a] 的基础上面减去 dp[b] 和 childrenCount[b]
 * dp[a] = dp[a] - (dp[b] + childrenCount[b])
 * 新的 childrenCount[a] 需要在原来的 childrenCount[a] 的基础上面减去 childrenCount[b]
 * childrenCount[a] = childrenCount[a] - childrenCount[b];
 *
 * b 变成了 a 的父节点
 * 新的 dp[b] 需要在原来的 dp[b] 的基础上面加上 dp[i] 和 childrenCount[a].
 * dp[b] = dp[b] + (dp[a] + childrenCount[a])
 * 新的 childrenCount[b] 需要在原来的 childrenCount[b] 的基础上面加上 childrenCount[a]
 * childrenCount[b] = childrenCount[b] + childrenCount[a]
 *
 * 我们递归调用，可以计算出来整个树中的每个节点作为根节点的时候的距离之和
 *
 * 834. 树中距离之和
 *
 * 给定一个无向、连通的树。树中有 N 个标记为 0...N-1 的节点以及 N-1 条边 。
 *
 * 第 i 条边连接节点 edges[i][0] 和 edges[i][1] 。
 *
 * 返回一个表示节点 i 与其他所有节点距离之和的列表 ans。
 *
 * 示例 1:
 *
 * 输入: N = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
 * 输出: [8,12,6,10,10,10]
 * 解释:
 * 如下为给定的树的示意图：
 * 0
 * / \
 * 1   2
 * /|\
 * 3 4 5
 *
 * 我们可以计算出 dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
 * 也就是 1 + 1 + 2 + 2 + 2 = 8。 因此，answer[0] = 8，以此类推。
 *
 * 说明: 1 <= N <= 10000
 */
public class Question0834 {
    public static void main(String[] args) {
        Question0834 demo = new Question0834();
        demo.sumOfDistancesInTree(5, new int[][]{{2, 0}, {3, 0}, {4, 0}, {1, 2}});
    }

    private int[] dp;

    private int[] childrenCount;

    private Map<Integer, List<Integer>> graphs;

    private int[] answers;

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        init(N, edges);
        initDbAndChildren(0, -1);
        getDbAndChildre(0, -1);
        return answers;
    }

    private void getDbAndChildre(int a, int b) {
        answers[a] = dp[a];
        List<Integer> children = graphs.get(a);
        if (children != null) {
            for (Integer child : children) {
                if (child != b) {
                    int[] back = copyBack(a, child);
                    swap(a, child);
                    getDbAndChildre(child, a);
                    roolBack(a, child, back);
                }
            }
        }
    }

    private void swap(int a, int b) {
        dp[a] = dp[a] - (dp[b] + childrenCount[b]);
        childrenCount[a] = childrenCount[a] - childrenCount[b];
        dp[b] = dp[b] + (dp[a] + childrenCount[a]);
        childrenCount[b] = childrenCount[b] + childrenCount[a];
    }

    private int[] copyBack(int a, int b) {
        return new int[]{dp[a], dp[b], childrenCount[a], childrenCount[b]};
    }

    private void roolBack(int a, int b, int[] back) {
        dp[a] = back[0];
        dp[b] = back[1];
        childrenCount[a] = back[2];
        childrenCount[b] = back[3];
    }

    private void initDbAndChildren(int a, int b) {
        dp[a] = 0;
        childrenCount[a] = 0;
        List<Integer> children = graphs.get(a);
        if (children != null) {
            for (int child : children) {
                if (child != b) {
                    initDbAndChildren(child, a);
                    dp[a] = dp[a] + (dp[child] + childrenCount[child]);
                    childrenCount[a] = childrenCount[a] + childrenCount[child];
                }
            }

            childrenCount[a] = childrenCount[a] + 1;
        }
    }


    private void init(int N, int[][] edges) {
        dp = new int[N];
        childrenCount = new int[N];
        graphs = new HashMap<>(N);
        answers = new int[N];

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            addGraph(a, b);
            addGraph(b, a);
        }
    }

    private void addGraph(int a, int b) {
        List<Integer> nodes = graphs.get(a);
        if (nodes == null) {
            nodes = new ArrayList<>();
            graphs.put(a, nodes);
        }
        nodes.add(b);
    }
}
