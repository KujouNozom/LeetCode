package com.sxg.leetcode.question.data2020_0x.no0101_0150;

import com.sxg.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: Question0103
 * @Author: Su_N
 * @Date: 2020/5/23 9:19
 * @Description: 类似102, 使用双端队列
 * 103. 二叉树的锯齿形层次遍历
 * <p>
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 返回锯齿形层次遍历如下：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 */
public class Question0103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.addFirst(root);
        boolean isLeft = true;
        while (!queue.isEmpty()) {
            List<Integer> tempResult = new ArrayList<>();
            Deque<TreeNode> tempQueue = new LinkedList<>();

            while (!queue.isEmpty()) {
                TreeNode temp;
                if (isLeft) {
                    temp = queue.removeFirst();
                } else {
                    temp = queue.removeLast();
                }

                tempResult.add(temp.val);
                if (isLeft) {
                    if (temp.left != null) {
                        tempQueue.addLast(temp.left);
                    }
                    if (temp.right != null) {
                        tempQueue.addLast(temp.right);
                    }
                } else {
                    if (temp.right != null) {
                        tempQueue.addFirst(temp.right);
                    }
                    if (temp.left != null) {
                        tempQueue.addFirst(temp.left);
                    }
                }
            }

            result.add(tempResult);
            queue = tempQueue;
            isLeft = !isLeft;
        }

        return result;
    }
}
