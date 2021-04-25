package com.sxg.leetcode.question;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.sxg.leetcode.entity.TreeNode;

/**
 * @ClassName: Question0145
 * @Author: Su_N
 * @Date: 2021/2/3 20:16
 * @Description: 145. 二叉树的后序遍历
 */
public class Question0145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        stack.push(root);

        while (!stack.empty()) {
            TreeNode current = stack.peek();
            if ((current.left == null && current.right == null)
                || (pre != null && (pre == current.left || pre == current.right))) {
                ans.add(stack.pop().val);
                pre = current;
            } else {
                if (current.right != null) {
                    stack.push(current.right);
                }
                if (current.left != null) {
                    stack.push(current.left);
                }
            }

        }

        return ans;
    }
}
