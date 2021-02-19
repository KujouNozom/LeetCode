package com.sxg.leetcode.question.data2020_0x.no0201_0250;

import com.sxg.leetcode.entity.TreeNode;

import java.util.Stack;

/**
 * @ClassName: Question0222
 * @Author: Su_N
 * @Date: 2020/6/30 23:22
 * @Description: 二分查找
 * 我们可以先通过计算树的深度，然后计算出最大最小的节点个数，作为左右区间
 * 然后通过二分查找，找到中间点的序号
 * 通过序号可以计算出每一层父节点的序号，然后从根节点遍历查看叶子节点是够存在，然后修改左右区间
 * 直到左右区间重合
 *
 *
 * 222. 完全二叉树的节点个数
 *
 * 给出一个完全二叉树，求出该树的节点个数。
 *
 * 说明：
 *
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 *
 * 示例:
 *
 * 输入:
 * 1
 * / \
 * 2   3
 * / \  /
 * 4  5 6
 *
 * 输出: 6
 */
public class Question0222 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        Question0222 demo = new Question0222();
        demo.countNodes(root);
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int dep = getDep(root);

        int left = (int) Math.pow(2, dep - 1);
        int right = (int) Math.pow(2, dep) - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            Stack<Integer> parents = getParents(mid);

            TreeNode lastNode = getLastNode(root, parents);

            if (lastNode == null) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        Stack<Integer> parents = getParents(left);
        TreeNode lastNode = getLastNode(root, parents);

        if (lastNode != null) {
            return left;
        } else {
            return left - 1;
        }
    }

    private int getDep(TreeNode root) {
        int dep = 0;
        TreeNode leftChild = root;
        while (leftChild != null) {
            dep++;
            leftChild = leftChild.left;
        }
        return dep;
    }

    private TreeNode getLastNode(TreeNode root, Stack<Integer> parents) {
        TreeNode current = root;
        while (!parents.isEmpty()) {
            int childIndex = parents.pop();
            if (childIndex % 2 == 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return current;
    }

    private Stack<Integer> getParents(int mid) {
        Stack<Integer> parents = new Stack<>();
        int parentIndex = mid;
        while (parentIndex != 1) {
            parents.push(parentIndex);
            parentIndex = parentIndex / 2;
        }
        return parents;
    }
}
