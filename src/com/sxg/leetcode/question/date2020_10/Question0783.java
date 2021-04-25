package com.sxg.leetcode.question.date2020_10;

import com.sxg.leetcode.entity.TreeNode;

/**
 * @ClassName: Question0783
 * @Author: Su_N
 * @Date: 2020/10/12 23:21
 * @Description: 先序遍历
 * 783. 二叉搜索树节点最小距离
 *
 * 给定一个二叉搜索树的根节点 root，返回树中任意两节点的差的最小值。
 *
 *
 *
 * 示例：
 *
 * 输入: root = [4,2,6,1,3,null,null]
 * 输出: 1
 * 解释:
 * 注意，root是树节点对象(TreeNode object)，而不是数组。
 *
 * 给定的树 [4,2,6,1,3,null,null] 可表示为下图:
 *
 * 4
 * /   \
 * 2      6
 * / \
 * 1   3
 *
 * 最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
 *
 *
 *
 * 注意：
 *
 * 二叉树的大小范围在 2 到 100。
 * 二叉树总是有效的，每个节点的值都是整数，且不重复。
 * 本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/ 相同
 */
public class Question0783 {
    private int min;

    private int pre;

    public int minDiffInBST(TreeNode root) {
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
