package com.sxg.leetcode.question;

import com.sxg.leetcode.entity.TreeNode;

/**
 * @ClassName: Question1008
 * @Author: Su_N
 * @Date: 2020/12/8 23:51
 * @Description: 1008. 前序遍历构造二叉搜索树
 * 返回与给定前序遍历 preorder 相匹配的二叉搜索树（binary search tree）的根结点。
 * (回想一下，二叉搜索树是二叉树的一种，其每个节点都满足以下规则，对于 node.left 的任何后代，值总 < node.val，而 node.right 的任何后代，值总 > node.val。此外，前序遍历首先显示节点 node 的值，然后遍历 node.left，接着遍历 node.right。）
 * 题目保证，对于给定的测试用例，总能找到满足要求的二叉搜索树。
 *
 * 示例：
 * 输入：[8,5,1,7,10,12]
 * 输出：[8,5,10,1,7,null,12]
 *
 * 提示：
 *
 * 1 <= preorder.length <= 100
 * 1 <= preorder[i] <= 10^8
 * preorder 中的值互不相同
 */
public class Question1008 {
    public TreeNode bstFromPreorder(int[] preorder) {
        return getNode(0, preorder.length - 1, preorder);
    }

    private TreeNode getNode(int start, int end, int[] datas) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(datas[start]);
        }

        int rootValue = datas[start];
        TreeNode root = new TreeNode(rootValue);
        int index = start + 1;
        while (index <= end && datas[index] < rootValue) {
            index++;
        }

        root.left = getNode(start + 1, index - 1, datas);
        root.right = getNode(index, end, datas);
        return root;
    }
}
