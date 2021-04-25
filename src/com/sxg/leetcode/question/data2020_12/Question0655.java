package com.sxg.leetcode.question;

import com.sxg.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Question0655
 * @Author: Su_N
 * @Date: 2020/12/10 22:52
 * @Description: 递归
 * 655. 输出二叉树
 * 中等
 * 在一个 m*n 的二维字符串数组中输出二叉树，并遵守以下规则：
 *
 * 行数 m 应当等于给定二叉树的高度。
 * 列数 n 应当总是奇数。
 * 根节点的值（以字符串格式给出）应当放在可放置的第一行正中间。根节点所在的行与列会将剩余空间划分为两部分（左下部分和右下部分）。你应该将左子树输出在左下部分，右子树输出在右下部分。左下和右下部分应当有相同的大小。即使一个子树为空而另一个非空，你不需要为空的子树输出任何东西，但仍需要为另一个子树留出足够的空间。然而，如果两个子树都为空则不需要为它们留出任何空间。
 * 每个未使用的空间应包含一个空的字符串""。
 * 使用相同的规则输出子树。
 *
 * 示例 1:
 *
 * 输入:
 * 1
 * /
 * 2
 * 输出:
 * [["", "1", ""],
 * ["2", "", ""]]
 *
 * 示例 2:
 *
 * 输入:
 * 1
 * / \
 * 2   3
 * \
 * 4
 * 输出:
 * [["", "", "", "1", "", "", ""],
 * ["", "2", "", "", "", "3", ""],
 * ["", "", "4", "", "", "", ""]]
 *
 * 示例 3:
 *
 * 输入:
 * 1
 * / \
 * 2   5
 * /
 * 3
 * /
 * 4
 * 输出:
 * [["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
 * ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
 * ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
 * ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
 *
 * 注意: 二叉树的高度在范围 [1, 10] 中。
 */
public class Question0655 {
    private List<List<String>> ans;

    public List<List<String>> printTree(TreeNode root) {
        int m = getDepth(root);
        int n = (int) Math.pow(2, m) - 1;
        init(m, n);
        fillValue(0, n - 1, 0, root);
        return ans;
    }

    private void init(int m, int n) {
        ans = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            List<String> temp = new ArrayList<>(n);
            for (int j = 0; j < n; j++) {
                temp.add("");
            }
            ans.add(temp);
        }
    }

    private void fillValue(int start, int end, int row, TreeNode node) {
        if (node != null) {
            int mid = (start + end) / 2;
            ans.get(row).set(mid, String.valueOf(node.val));
            fillValue(start, mid - 1, row + 1, node.left);
            fillValue(mid + 1, end, row + 1, node.right);
        }
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
        }
    }
}
