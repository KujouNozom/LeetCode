package com.sxg.leetcode.question.data2020_0x.no0101_0150;

import com.sxg.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName: Question0102
 * @Author: Su_N
 * @Date: 2020/5/23 8:49
 * @Description: 使用队列
 * 102. 二叉树的层序遍历
 * <p>
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * <p>
 * <p>
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 */
public class Question0102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> tempResult = new ArrayList<>();
            Queue<TreeNode> tempQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode temp = queue.poll();
                tempResult.add(temp.val);
                if (temp.left != null) {
                    tempQueue.offer(temp.left);
                }

                if (temp.right != null) {
                    tempQueue.offer(temp.right);
                }
            }

            result.add(tempResult);
            queue = tempQueue;
        }

        return result;
    }
}
