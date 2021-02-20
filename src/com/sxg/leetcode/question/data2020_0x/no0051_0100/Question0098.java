package com.sxg.leetcode.question.data2020_0x.no0051_0100;

import com.sxg.leetcode.entity.TreeNode;

/**
 * @ClassName: Question0098
 * @Author: Su_N
 * @Date: 2020/5/22 9:04
 * @Description: 递归
 * 设置两个值，一个表示当前节点属于的那个最近的右子树的值，一个表示当前节点属于的那个最近的左子树的值
 * 判断如果当前节点的值和 这两个值相比不满足（如果值为空，说明当前节点不属于任何左右子树，不需要判断），返回false
 * 如果满足，递归左右子树（注意更新左右子树的值，遍历左子树的时候刷新最近左子树的值为当前节点，右子树同理）
 * 98. 验证二叉搜索树
 * <p>
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 * <p>
 * 示例 2:
 * <p>
 * 输入:
 * 5
 * / \
 * 1   4
 * / \
 * 3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 * 根节点的值为 5 ，但是其右子节点值为 4 。
 */
public class Question0098 {
    public boolean isValidBST(TreeNode root) {
        return function(root, null, null);
    }

    private boolean function(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }

        if ((min != null && root.val >= min) || (max != null && root.val <= max)) {
            return false;
        }

        return function(root.left, root.val, max) && function(root.right, min, root.val);
    }

}
