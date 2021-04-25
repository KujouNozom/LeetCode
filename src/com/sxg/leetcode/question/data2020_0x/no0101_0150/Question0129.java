package com.sxg.leetcode.question.data2020_0x.no0101_0150;

import com.sxg.leetcode.entity.TreeNode;

/**
 * @ClassName: Question0129
 * @Author: Su_N
 * @Date: 2020/5/29 21:47
 * @Description: 深度搜索
 * 使用深度搜索，递归
 * 方法两个参数，一个是当前的计数和 current，一个数当前节点 root
 * 如果当前节点有值，那么之前的计数会左移一位，新的计数和为 current*10+root.val
 * 若果是叶子节点，则不会在继续计算，返回当前值
 * 如果不是叶子节点，那么返回值为左右子节点的递归调用之和
 * 129. 求根到叶子节点数字之和
 * <p>
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 * <p>
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 * <p>
 * 计算从根到叶子节点生成的所有数字之和。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 1
 * / \
 * 2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 * <p>
 * 示例 2:
 * <p>
 * 输入: [4,9,0,5,1]
 * 4
 * / \
 * 9   0
 * / \
 * 5   1
 * 输出: 1026
 * 解释:
 * 从根到叶子节点路径 4->9->5 代表数字 495.
 * 从根到叶子节点路径 4->9->1 代表数字 491.
 * 从根到叶子节点路径 4->0 代表数字 40.
 * 因此，数字总和 = 495 + 491 + 40 = 1026.
 */
public class Question0129 {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return function(0, root);
    }

    private int function(int current, TreeNode root) {
        if (root == null) {
            return 0;
        }

        int temp = current * 10 + root.val;
        if (root.left == null && root.right == null) {
            return temp;
        }

        return function(temp, root.left) + function(temp, root.right);
    }
}
