package com.sxg.leetcode.question.data2020_0x.offer;

import com.sxg.leetcode.entity.TreeNode;

/**
 * @ClassName: Offer028
 * @Author: Su_N
 * @Date: 2020/11/4 0:08
 * @Description: 递归
 * 剑指 Offer 28. 对称的二叉树
 *
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 *
 *
 *
 * 示例 1：
 *
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 *
 * 示例 2：
 *
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 *
 *
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 1000
 */
public class Offer028 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return function(root.left, root.right);
    }

    private boolean function(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left != null && right != null && left.val == right.val) {
            return function(left.left, right.right) && function(left.right, right.left);
        }

        return false;
    }
}
