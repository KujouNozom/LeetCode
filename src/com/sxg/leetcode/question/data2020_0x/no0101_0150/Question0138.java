package com.sxg.leetcode.question.data2020_0x.no0101_0150;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @ClassName: Question0138
 * @Author: Su_N
 * @Date: 2020/6/2 23:30
 * @Description: 广度搜索
 * 使用一个Map存储已经访问的节点，key是源节点，value是克隆的节点
 * 使用一个队列保存需要遍历的节点
 * 队列不为空的时候，每次取出一个节点，获取它的两个指针的关系节点
 * 如果关系节点没被方位，复制节点，建立关系，保存到map，同时加入节点到队列中
 * 如果已经访问过，建立关系
 * <p>
 * 138. 复制带随机指针的链表
 * <p>
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 * <p>
 * 要求返回这个链表的 深拷贝。
 * <p>
 * 我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 * <p>
 * val：一个表示 Node.val 的整数。
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 * <p>
 * 示例 3：
 * <p>
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 * <p>
 * 示例 4：
 * <p>
 * 输入：head = []
 * 输出：[]
 * 解释：给定的链表为空（空指针），因此返回 null。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * -10000 <= Node.val <= 10000
 * Node.random 为空（null）或指向链表中的节点。
 * 节点数目不超过 1000 。
 */
public class Question0138 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Map<Node, Node> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        Node tempHead = new Node(head.val);
        visited.put(head, tempHead);
        queue.offer(head);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            Node next = current.next;
            if (next != null) {
                if (!visited.containsKey(next)) {
                    Node tempNext = new Node(next.val);
                    queue.offer(next);
                    visited.put(next, tempNext);
                }
                visited.get(current).next = visited.get(next);
            } else {
                visited.get(current).next = null;
            }

            Node random = current.random;
            if (random != null) {
                if (!visited.containsKey(random)) {
                    Node tempRandom = new Node(random.val);
                    queue.offer(random);
                    visited.put(random, tempRandom);
                }
                visited.get(current).random = visited.get(random);
            } else {
                visited.get(current).random = null;
            }
        }

        return tempHead;
    }

    class Node {
        int val;

        Node next;

        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
