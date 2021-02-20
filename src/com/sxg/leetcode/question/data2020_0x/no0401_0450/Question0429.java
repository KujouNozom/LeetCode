package com.sxg.leetcode.question.data2020_0x.no0401_0450;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: Question0099
 * @Author: Su_N
 * @Date: 2020/8/7 20:00
 * @Description: 使用一个队列
 *
 * 429. N叉树的层序遍历
 *
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 *
 * 例如，给定一个 3叉树 :
 *
 *
 *
 *
 *
 * 返回其层序遍历:
 *
 * [
 * [1],
 * [3,2,4],
 * [5,6]
 * ]
 *
 *
 *
 * 说明:
 *
 * 树的深度不会超过 1000。
 * 树的节点总数不会超过 5000。
 */
public class Question0429 {
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> answers = new ArrayList<>();
        Deque<Node> deque = new LinkedList<>();
        deque.addLast(root);

        while (!deque.isEmpty()) {
            List<Integer> answer = new ArrayList<>();
            Deque<Node> temp = new LinkedList<>();

            deque.forEach(node -> {
                answer.add(node.val);
                if (node.children != null) {
                    temp.addAll(node.children);
                }

            });

            answers.add(answer);
            deque = temp;
        }

        return answers;
    }
}

class Node {
    public int val;

    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};