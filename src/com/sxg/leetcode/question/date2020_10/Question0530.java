package com.sxg.leetcode.question.date2020_10;

import com.sxg.leetcode.entity.TreeNode;

/**
 * @ClassName: Question0530
 * @Author: Su_N
 * @Date: 2020/10/12 23:19
 * @Description: 前序遍历
 * 530. 二叉搜索树的最小绝对差
 *
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 *
 *
 *
 * 示例：
 *
 * 输入：
 *
 * 1
 * \
 * 3
 * /
 * 2
 *
 * 输出：
 * 1
 *
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 *
 *
 *
 * 提示：
 *
 * 树中至少有 2 个节点。
 * 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 相同
 */
public class Question0530 {
    private int min;

    private int pre;

    public int getMinimumDifference(TreeNode root) {
        min = Integer.MAX_VALUE;
        pre = -1;
        function(root);
        return min;
    }

    private void function(TreeNode root) {
        if (root != null) {
            function(root.left);
            if (pre != -1) {
                min = Math.min(min, Math.abs(root.val - pre));
            }
            pre = root.val;
            function(root.right);
        }
    }
}
