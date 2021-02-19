package com.sxg.leetcode.question.data2020_0x.no0101_0150;

import com.sxg.leetcode.entity.TreeNode;

/**
 * @ClassName: Question0110
 * @Author: Su_N
 * @Date: 2020/8/6 20:24
 * @Description: 110. 平衡二叉树
 *
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 *
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 *
 * 返回 false 。
 */
public class Question0110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(getHight(root.left) - getHight(root.right)) <= 1 && isBalanced(root.right) && isBalanced(root.left);
    }

    private int getHight(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getHight(root.right), getHight(root.left)) + 1;
    }
}
