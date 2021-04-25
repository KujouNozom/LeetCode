package com.sxg.leetcode.entity;

/**
 * @ClassName: Node
 * @Author: Su_N
 * @Date: 2020/5/26 9:30
 * @Description:
 */
public class Node {
    public int val;

    public Node left;

    public Node right;

    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
