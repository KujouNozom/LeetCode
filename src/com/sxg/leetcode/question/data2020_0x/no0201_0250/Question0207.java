package com.sxg.leetcode.question.data2020_0x.no0201_0250;

import java.util.*;

/**
 * @ClassName: Question0207
 * @Author: Su_N
 * @Date: 2020/6/22 22:15
 * @Description: 无向图拓扑排序
 * 可以将这些课程和前后条件组成一个图，如果图中有环，则不发实现课程学习（依赖关系出现环）
 * 判断有向图有环的方法有两个
 * 1.DFS设置访问过的节点，如果一个节点访问两次，说明有环
 * 2.拓扑的方式，构建入度表，将所有入度为0的点以及他们的边删除，更新入度，如果最后剩余的节点入度都大于0，说明有环
 * 我们使用第二种方法
 *
 *
 * 207. 课程表
 *
 * 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
 *
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
 *
 * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 *
 *
 *
 * 示例 1:
 *
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 *
 * 示例 2:
 *
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 *
 *
 *
 * 提示：
 *
 * 输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。详情请参见图的表示法。
 * 你可以假定输入的先决条件中没有重复的边。
 * 1 <= numCourses <= 10^5
 */
public class Question0207 {
    public static void main(String[] args) {
        Question0207 demo = new Question0207();
        demo.canFinish(2, new int[][]{{1, 0}});
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites == null) {
            return false;
        }

        Map<Integer, NodeInfo> nodeInfos = new HashMap<>();
        for (int[] temp : prerequisites) {
            int in = temp[0];
            int out = temp[1];

            NodeInfo inNode = nodeInfos.get(in);
            if (inNode == null) {
                inNode = new NodeInfo(in);
                nodeInfos.put(in, inNode);
            }
            inNode.addInDegree();

            NodeInfo outNode = nodeInfos.get(out);
            if (outNode == null) {
                outNode = new NodeInfo(out);
                nodeInfos.put(out, outNode);
            }
            outNode.addSideNode(inNode);
        }

        boolean endFlag = false;
        List<NodeInfo> collection = new ArrayList<>();
        collection.addAll(nodeInfos.values());
        while (!endFlag) {
            endFlag = true;
            Iterator<NodeInfo> iterable = collection.iterator();
            while (iterable.hasNext()) {
                NodeInfo nodeInfo = iterable.next();
                if (nodeInfo.inDegree == 0) {
                    nodeInfo.sideNodes.forEach(sideNode -> nodeInfos.get(sideNode.val).subInDegree());
                    iterable.remove();
                    endFlag = false;
                }
            }
        }

        return collection.isEmpty();
    }
}

class NodeInfo {
    public int val;

    public List<NodeInfo> sideNodes;

    public int inDegree;


    public NodeInfo(int val) {
        this.val = val;
        this.sideNodes = new ArrayList<>();
        this.inDegree = 0;
    }

    public NodeInfo(int val, List<NodeInfo> sideNodes, int inDegree) {
        this.val = val;
        this.sideNodes = sideNodes;
        this.inDegree = inDegree;
    }

    public void addInDegree() {
        this.inDegree++;
    }

    public void subInDegree() {
        this.inDegree--;
    }

    public void addSideNode(NodeInfo node) {
        this.sideNodes.add(node);
    }
}
