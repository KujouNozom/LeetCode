package com.sxg.leetcode.question.data2020_0x.no0051_0100;

import com.sxg.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Question0095
 * @Author: Su_N
 * @Date: 2020/5/21 9:04
 * @Description: 递归
 * 思路类似 0096
 * f(1,n):表示n个节点可以构成的二叉搜索树
 * 我们从n个节点中取出一个i当做根节点，剩下的分为两组(1,i-1)和(i+1,n)
 * 分别构建这两组二叉树，然后它们的组合加上根节点，就是所有二叉树个数
 * 如果f(m,n)中 m>n 说明没有节点了，子树为null,终止条件
 * 95. 不同的二叉搜索树 II
 * <p>
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出:
 * [
 * [1,null,3,2],
 * [3,2,null,1],
 * [3,1,null,null,2],
 * [2,1,3],
 * [1,null,2,null,3]
 * ]
 * 解释:
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 */
public class Question0095 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }

        return function(1, n);
    }

    private List<TreeNode> function(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }

        for (int index = start; index <= end; index++) {
            List<TreeNode> lefts = function(start, index - 1);
            List<TreeNode> rights = function(index + 1, end);

            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode root = new TreeNode(index);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }

        return result;
    }
}
