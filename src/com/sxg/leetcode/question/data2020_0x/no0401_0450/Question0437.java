package com.sxg.leetcode.question.data2020_0x.no0401_0450;

import com.sxg.leetcode.entity.TreeNode;

/**
 * @ClassName: Question0437
 * @Author: Su_N
 * @Date: 2020/8/10 20:34
 * @Description: 437. 路径总和 III
 *
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 *
 * 找出路径和等于给定数值的路径总数。
 *
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 *
 * 示例：
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 * 10
 * /  \
 * 5   -3
 * / \    \
 * 3   2   11
 * / \   \
 * 3  -2   1
 *
 * 返回 3。和等于 8 的路径有:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 */
public class Question0437 {
    private int target = 0;

    public int pathSum(TreeNode root, int sum) {
        target = sum;
        return function(new int[0], root);
    }

    private int function(int[] preSums, TreeNode root) {
        int count = 0;
        int length = preSums.length;
        int[] currentSums = new int[length + 1];
        if (root == null) return count;

        int val = root.val;
        for (int index = 0; index < length; index++) {
            Integer currentSum = preSums[index] + val;
            if (currentSum == target) count++;
            currentSums[index] = currentSum;
        }

        if (val == target) count++;
        currentSums[length] = val;

        return count + function(currentSums, root.left) + function(currentSums, root.right);
    }

}
