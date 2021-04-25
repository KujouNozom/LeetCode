package com.sxg.leetcode.question.data2020_0x.no0101_0150;

import com.sxg.leetcode.entity.Node;

/**
 * @ClassName: Question0116
 * @Author: Su_N
 * @Date: 2020/5/26 9:25
 * @Description: 递归，按照层序遍历
 * 一个节点的 next 只有三种情况
 * 1.next 是父节点的子节点，node.next = parentNode.right
 * 2.next 是另一个节点的左孩子节点，我们通过观察发现，这种情况下，node.next = parentNode.next.left
 * 3.next 为 null，这种节点的父节点的 next 也是 null
 * 因为我们是按照层序遍历的因此，父节点那一层的 next 都已经设置的好了
 * 我们从根节点开始，遍历每层节点，设置它的孩子节点的 next 关系
 * 我们可以发现 只要获取每一层的最左边的节点，通过next 就可以遍历一层（当前层是上一层的子节点，所以next 在上一层就已经设置好了）
 * 116. 填充每个节点的下一个右侧节点指针
 * <p>
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * <p>
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":{"$id":"6","left":null,"next":null,"right":null,"val":6},"next":null,"right":{"$id":"7","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}
 * <p>
 * 输出：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":{"$id":"6","left":null,"next":null,"right":null,"val":7},"right":null,"val":6},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"7","left":{"$ref":"5"},"next":null,"right":{"$ref":"6"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"7"},"val":1}
 * <p>
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 */
public class Question0116 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Node currentLevel = root;

        while (currentLevel.left != null) {
            Node head = currentLevel;

            while (head != null) {
                head.left.next = head.right;

                if (head.next != null) {
                    head.right.next = head.next.left;
                }

                head = head.next;
            }

            currentLevel = currentLevel.left;
        }

        return root;
    }
}
