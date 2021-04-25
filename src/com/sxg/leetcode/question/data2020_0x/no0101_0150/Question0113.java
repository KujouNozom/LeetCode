package com.sxg.leetcode.question.data2020_0x.no0101_0150;

import com.sxg.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Question0113
 * @Author: Su_N
 * @Date: 2020/5/25 10:52
 * @Description: 回溯
 * 递归遍历，当当前和大于指定值的时候，直接结束
 * 当是叶子节点的时候，判断和是否为sum，是的话添加到结果集
 * 113. 路径总和 II
 * <p>
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * <p>
 * 返回:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 */
public class Question0113 {
    private List<List<Integer>> result;

    private int target;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        target = sum;
        function(new ArrayList<>(), root, 0);

        return result;
    }

    private void function(List<Integer> current, TreeNode currentNode, int sum) {
        if (currentNode.right == null && currentNode.left == null) {
            if (sum + currentNode.val == target) {
                List<Integer> temp = new ArrayList<>();
                temp.addAll(current);
                temp.add(currentNode.val);
                result.add(temp);
            }
        } else {
            current.add(currentNode.val);
            if (currentNode.left != null) {
                function(current, currentNode.left, sum + currentNode.val);
            }

            if (currentNode.right != null) {
                function(current, currentNode.right, sum + currentNode.val);
            }
            current.remove(current.size() - 1);
        }
    }
}
