package com.sxg.leetcode.question.data2020_0x.no0201_0250;

import java.util.*;

/**
 * @ClassName: Question0210
 * @Author: Su_N
 * @Date: 2020/6/25 18:14
 * @Description: DFS 拓扑排序，如果有环则不能完成课程，否则任意一种拓扑排序都满足
 * 使用一个栈，存放已经搜索完成的点（所有相连的点都已经搜索完成）
 * 从点集合中取一个没有遍历的点a，遍历这个点的相连的点集合中的点b
 * 1.如果点b没有搜索，继续递归这个点的相连点集合
 * 2.如果点b是搜索中，那么说明有环（因为递归回到这个点b的时候，b在搜索中，说明前面这个点b是前面递归路径上面的一个点，但是又搜索到这个点，说名路径上面b之后又有一个点的相邻节点有b，产生环）
 * 3.如果点b是搜索完成，那么什么都不做，因为这个点已经在栈汇总（搜索的点a后入栈，和它相连的点在它前面都已经入栈了）
 *
 * 递归回到这个点a的时候，这个点搜索完成，入栈
 *
 * 如果没有发现环，并且所有点都已经遍历完，入栈，则顺序出栈就是一个拓扑遍历
 *
 * 210. 课程表 II
 *
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 *
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 *
 * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
 *
 * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
 *
 * 示例 1:
 *
 * 输入: 2, [[1,0]]
 * 输出: [0,1]
 * 解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
 *
 * 示例 2:
 *
 * 输入: 4, [[1,0],[2,0],[3,1],[3,2]]
 * 输出: [0,1,2,3] or [0,2,1,3]
 * 解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
 * 因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
 *
 * 说明:
 *
 * 输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
 * 你可以假定输入的先决条件中没有重复的边。
 *
 * 提示:
 *
 * 这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。
 * 通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。
 *
 * 拓扑排序也可以通过 BFS 完成。
 */
public class Question0210 {
    private Map<Integer, Integer> statuses;

    private Map<Integer, List<Integer>> nodes;

    private List<Integer> notVisitedNodes;

    private Stack<Integer> stack = new Stack<>();

    private static final int NO_SEARCH = 0;

    private static final int SEARCHING = 1;

    private static final int SEARCHED = 2;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        statuses = new HashMap<>();
        nodes = new HashMap<>();
        notVisitedNodes = new ArrayList<>();

        for (int index = 0; index < numCourses; index++) {
            notVisitedNodes.add(index);
            nodes.put(index, new ArrayList<>());
            statuses.put(index, NO_SEARCH);
        }

        stack = new Stack<>();

        for (int[] temp : prerequisites) {
            nodes.get(temp[1]).add(temp[0]);
        }

        while (!notVisitedNodes.isEmpty()) {
            Integer current = notVisitedNodes.get(0);
            if (!function(current)) {
                return new int[0];
            }
        }

        int[] answer = new int[numCourses];
        for (int index = 0; index < numCourses; index++) {
            answer[index] = stack.pop();
        }

        return answer;
    }

    private boolean function(Integer current) {
        statuses.put(current, SEARCHING);
        notVisitedNodes.remove(current);

        List<Integer> inNodes = nodes.get(current);
        if (inNodes != null) {
            for (Integer inNode : inNodes) {
                if (notVisitedNodes.contains(inNode)) {
                    if (!function(inNode)) {
                        return false;
                    }
                } else if (statuses.get(inNode) == SEARCHING) {
                    return false;
                }
            }
        }

        stack.push(current);
        statuses.put(current, SEARCHED);
        return true;
    }
}
