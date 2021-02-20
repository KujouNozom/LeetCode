package com.sxg.leetcode.question.data2020_0x.no0101_0150;

import com.sxg.leetcode.entity.TreeNode;

import java.util.Stack;

/**
 * @ClassName: Question0114
 * @Author: Su_N
 * @Date: 2020/5/26 8:25
 * @Description: 模拟先序遍历，迭代，右子树入栈，左子树替换右子树位置
 * 右子树为空的时候不入栈、
 * 终止条件是当前节点左子树为空，且栈里没有节点
 * 注意：每次使用左子树替换为右子树之后，左子树要置为null
 * 114. 二叉树展开为链表
 * <p>
 * 给定一个二叉树，原地将它展开为一个单链表。
 * <p>
 * <p>
 * <p>
 * 例如，给定二叉树
 * <p>
 * 1
 * / \
 * 2   5
 * / \   \
 * 3   4   6
 * <p>
 * 将其展开为：
 * <p>
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 */
public class Question0114 {
    public static void main(String[] args) {
        Question0114 demo = new Question0114();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(4);
        treeNode.right = new TreeNode(5);
        treeNode.right.right = new TreeNode(6);
        demo.flatten(treeNode);
    }

    public void flatten(TreeNode root) {
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        while (current != null) {
            if (current.right != null) {
                stack.push(current.right);
            }

            if (current.left != null) {
                current.right = current.left;
                current.left = null;
            } else {
                if (stack.isEmpty()) {
                    current.right = null;
                } else {
                    current.right = stack.pop();
                }
            }

            current = current.right;
        }

    }
}
