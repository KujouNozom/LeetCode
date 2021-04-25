package com.sxg.leetcode.question.data2020_0x.no0101_0150;

import com.sxg.leetcode.entity.TreeNode;

import java.util.Arrays;

/**
 * @ClassName: Question0105
 * @Author: Su_N
 * @Date: 2020/5/24 8:32
 * @Description: 递归
 * 前序遍历时，节点可以分为[根节点，左子树，右子树]
 * 中序遍历时，节点可以分为[左子树，根节点，左子树]
 * 每次跌倒传入两个序列，通过前序遍历的第一个节点获取根节点，然后既可以在中序中用这个根节点获取左右子树的中序序列
 * 因为左右子树的序列长度在前中序遍历的时候是想用的，可以获取前序序列
 * 然后递归调动获取左右子树
 * 终止条件是 前中序列为空
 * 105. 从前序与中序遍历序列构造二叉树
 * <p>
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * <p>
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 */
public class Question0105 {
    public static void main(String[] args) {
        Question0105 demo = new Question0105();
        TreeNode tt = demo.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println();
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        int rootValue = preorder[0];
        int rootIndex = findIndex(inorder, rootValue);
        int leftLength = rootIndex;

        TreeNode root = new TreeNode(rootValue);

        root.left = buildTree(Arrays.copyOfRange(preorder, 1, 1 + leftLength), Arrays.copyOfRange(inorder, 0, leftLength));
        root.right = buildTree(Arrays.copyOfRange(preorder, 1 + leftLength, preorder.length), Arrays.copyOfRange(inorder, 1 + leftLength, inorder.length));

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
