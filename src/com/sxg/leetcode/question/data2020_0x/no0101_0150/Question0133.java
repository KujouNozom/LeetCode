package com.sxg.leetcode.question.data2020_0x.no0101_0150;


import java.util.*;

/**
 * @ClassName: Question0133
 * @Author: Su_N
 * @Date: 2020/6/1 22:52
 * @Description: 深度搜索，广度搜索
 * 注意使用一个临时变量存储已经访问的点，因为是一个无向图，不这样会死循环
 * <p>
 * 使用一个 Map visited 存储已经访问过的点，Key 是原图的点，value 是克隆图的点
 * 使用广度搜索，需要一个队列存放未访问过的点集合，初始化为第一个点
 * 1.队列不为空的时候取出队列中的一个点，遍历这个点的所有邻接点
 * 2.如果 visited 中没有这个点，克隆一个这个点，并且将原始点和克隆点放入图中，并且将这个点放到队列中
 * 3.取 visited 中的原始点对应的 value 放入克隆图的邻接关系
 * <p>
 * <p>
 * 133. 克隆图
 * <p>
 * 给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
 * <p>
 * 图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
 * <p>
 * class Node {
 * public int val;
 * public List<Node> neighbors;
 * }
 * <p>
 * <p>
 * <p>
 * 测试用例格式：
 * <p>
 * 简单起见，每个节点的值都和它的索引相同。例如，第一个节点值为 1（val = 1），第二个节点值为 2（val = 2），以此类推。该图在测试用例中使用邻接列表表示。
 * <p>
 * 邻接列表 是用于表示有限图的无序列表的集合。每个列表都描述了图中节点的邻居集。
 * <p>
 * 给定节点将始终是图中的第一个节点（值为 1）。你必须将 给定节点的拷贝 作为对克隆图的引用返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：adjList = [[2,4],[1,3],[2,4],[1,3]]
 * 输出：[[2,4],[1,3],[2,4],[1,3]]
 * 解释：
 * 图中有 4 个节点。
 * 节点 1 的值是 1，它有两个邻居：节点 2 和 4 。
 * 节点 2 的值是 2，它有两个邻居：节点 1 和 3 。
 * 节点 3 的值是 3，它有两个邻居：节点 2 和 4 。
 * 节点 4 的值是 4，它有两个邻居：节点 1 和 3 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：adjList = [[]]
 * 输出：[[]]
 * 解释：输入包含一个空列表。该图仅仅只有一个值为 1 的节点，它没有任何邻居。
 * <p>
 * 示例 3：
 * <p>
 * 输入：adjList = []
 * 输出：[]
 * 解释：这个图是空的，它不含任何节点。
 * <p>
 * 示例 4：
 * <p>
 * 输入：adjList = [[2],[1]]
 * 输出：[[2],[1]]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 节点数不超过 100 。
 * 每个节点值 Node.val 都是唯一的，1 <= Node.val <= 100。
 * 无向图是一个简单图，这意味着图中没有重复的边，也没有自环。
 * 由于图是无向的，如果节点 p 是节点 q 的邻居，那么节点 q 也必须是节点 p 的邻居。
 * 图是连通图，你可以从给定节点访问到所有节点。
 */
public class Question0133 {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Map<Node, Node> visited = new HashMap<>();
        Node Head = new Node(node.val);
        visited.put(node, Head);

        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            for (Node neighbor : current.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, new Node(neighbor.val));
                    queue.offer(neighbor);
                }

                Node temp = visited.get(neighbor);
                visited.get(current).neighbors.add(temp);
            }
        }

        return Head;
    }

    class Node {
        public int val;

        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}


