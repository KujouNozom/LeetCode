package com.sxg.leetcode.question.data2020_0x.no0101_0150;

import com.sxg.leetcode.entity.TreeNode;

import java.util.Arrays;

/**
 * @ClassName: Question0106
 * @Author: Su_N
 * @Date: 2020/5/24 9:09
 * @Description: 类似105
 * 106. 从中序与后序遍历序列构造二叉树
 * <p>
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * <p>
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 */
public class Question0106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0 || inorder.length == 0) {
            return null;
        }

        int rootValue = postorder[postorder.length - 1];
        int rootIndex = findIndex(inorder, rootValue);
        int leftLength = rootIndex;

        TreeNode root = new TreeNode(rootValue);

        root.left = buildTree(Arrays.copyOfRange(inorder, 0, leftLength), Arrays.copyOfRange(postorder, 0, leftLength));
        root.right = buildTree(Arrays.copyOfRange(inorder, 1 + leftLength, inorder.length), Arrays.copyOfRange(postorder, leftLength, postorder.length - 1));

        return root;
    }

    private int findIndex(int[] datas, int key) {
        for (int index = 0; index < datas.length; index++) {
            if (datas[index] == key) {
                return index;
            }
        }

        return -1;
    }
}
