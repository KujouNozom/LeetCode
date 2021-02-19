package com.sxg.leetcode.question.data2020_0x.no0101_0150;

import com.sxg.leetcode.entity.Node;

/**
 * @ClassName: Question0117
 * @Author: Su_N
 * @Date: 2020/5/27 8:22
 * @Description: 类似116, 但是需要因为不是完美二叉树，需要查找下一个子节点
 * <p>
 * 117. 填充每个节点的下一个右侧节点指针 II
 * <p>
 * 给定一个二叉树
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
 * 进阶：
 * <p>
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：root = [1,2,3,4,5,null,7]
 * 输出：[1,#,2,3,#,4,5,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中的节点数小于 6000
 * -100 <= node.val <= 100
 */
public class Question0117 {

    public static void main(String[] args) {
        Question0117 demo = new Question0117();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(7);
        demo.connect(root);
    }


    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Node currentLevelHead = root;


        while (currentLevelHead != null) {
            currentLevelHead = buildChildLevel(currentLevelHead);
        }

        return root;
    }

    private Node buildChildLevel(Node currentLevel) {
        Node nextChildHead = new Node(0);
        Node nextChild = nextChildHead;

        while (currentLevel != null) {
            if (currentLevel.left != null) {
                nextChild.next = currentLevel.left;
                nextChild = nextChild.next;
            }

            if (currentLevel.right != null) {
                nextChild.next = currentLevel.right;
                nextChild = nextChild.next;
            }

            currentLevel = currentLevel.next;
        }

        return nextChildHead.next;
    }
}
