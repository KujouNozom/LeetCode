package com.sxg.leetcode.question.data2020_0x.no0151_0200;

import com.sxg.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: Question0199
 * @Author: Su_N
 * @Date: 2020/6/19 22:53
 * @Description: 广度搜索
 * 使用广度搜索，一层一层搜索树，每次队列最后一元素就是最右的元素
 *
 * 199. 二叉树的右视图
 *
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 * 1            <---
 * /   \
 * 2     3         <---
 * \     \
 * 5     4       <---
 */
public class Question0199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            result.add(deque.getLast().val);

            Deque<TreeNode> temp = new LinkedList<>();
            deque.forEach(a -> {
                if (a.left != null) {
                    temp.addLast(a.left);
                }

                if (a.right != null) {
                    temp.addLast(a.right);
                }
            });
            deque = temp;
        }

        return result;
    }
}
