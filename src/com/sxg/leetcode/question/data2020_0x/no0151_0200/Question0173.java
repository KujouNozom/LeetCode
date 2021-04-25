package com.sxg.leetcode.question.data2020_0x.no0151_0200;

import com.sxg.leetcode.entity.TreeNode;

import java.util.Stack;

/**
 * @ClassName: Question0173
 * @Author: Su_N
 * @Date: 2020/6/16 23:11
 * @Description: 中序遍历，使用栈
 * 每次找到最小数，实际上就是中序遍历，使用一个栈
 * 先实现一个函数，将一个节点的所有左孩子节点递归放到栈里面
 * 初始化的时候调用一次
 * 每次 next 获取栈顶元素，返回栈顶元素，如果栈顶元素有右孩子节点，对右孩子节点调用这个函数（左孩子节点不用考虑，因为左孩子节点肯定已经入栈出栈遍历过了）
 * hasnext 只需要判断栈里面还有没有元素
 * 173. 二叉搜索树迭代器
 *
 * 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 *
 * 调用 next() 将返回二叉搜索树中的下一个最小的数。
 *
 *
 *
 * 示例：
 *
 * BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // 返回 3
 * iterator.next();    // 返回 7
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 9
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 15
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 20
 * iterator.hasNext(); // 返回 false
 *
 *
 *
 * 提示：
 *
 * next() 和 hasNext() 操作的时间复杂度是 O(1)，并使用 O(h) 内存，其中 h 是树的高度。
 * 你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 中至少存在一个下一个最小的数。
 */
public class Question0173 {

}

class BSTIterator {
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushLeftChild(root);
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        if (stack.isEmpty()) {
            return -1;
        }
        TreeNode current = stack.pop();
        pushLeftChild(current.right);
        return current.val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushLeftChild(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
}