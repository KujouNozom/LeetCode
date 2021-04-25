package com.sxg.leetcode.question.data2020_0x.no0201_0250;

import com.sxg.leetcode.entity.TreeNode;

import java.util.Stack;

/**
 * @ClassName: Question0230
 * @Author: Su_N
 * @Date: 2020/7/2 22:51
 * @Description: 深度搜索
 * 平衡二叉树的中序深度遍历，就是升序列表
 * 使用一个栈来存贮遍历过的元素，以及他们的左子树
 * 当搜索到底的时候，出栈一个元素（这个元素就是当前最小的元素），计数器+1，并且在遍历它的右子节点的左子树
 * 当计数器等于k的时候，就说明已经
 *
 * 230. 二叉搜索树中第K小的元素
 *
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 *
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 * 2
 * 输出: 1
 *
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * 输出: 3
 *
 * 进阶：
 * 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
 */
public class Question0230 {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;

        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
                continue;
            }

            root = stack.pop();
            count++;
            if (count == k) {
                return root.val;
            } else {
                root = root.right;
            }
        }

        return -1;
    }
}
