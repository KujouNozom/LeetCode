package com.sxg.leetcode.question.data2020_0x.no0101_0150;

import com.sxg.leetcode.entity.ListNode;
import com.sxg.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Question0109
 * @Author: Su_N
 * @Date: 2020/5/25 8:06
 * @Description: 递归
 * 首先转换为一个数组，然后找中间的节点作为根节点
 * 多中间节点前后两组节点 递归调用，构建左右子树
 * 109. 有序链表转换二叉搜索树
 * <p>
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * 示例:
 * <p>
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 * <p>
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 */
public class Question0109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        List<Integer> datas = new ArrayList<>();
        while (head != null) {
            datas.add(head.val);
            head = head.next;
        }

        return function(datas, 0, datas.size() - 1);

    }

    private TreeNode function(List<Integer> datats, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;

        TreeNode root = new TreeNode(datats.get(mid));

        root.left = function(datats, start, mid - 1);
        root.right = function(datats, mid + 1, end);

        return root;
    }
}
