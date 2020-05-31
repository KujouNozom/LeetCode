package com.sxg.leetcode.finished.no0001_0050;

import com.sxg.leetcode.entity.ListNode;

/**
 * @ClassName: Question0024
 * @Author: Su_N
 * @Date: 2020/4/27 22:44
 * @Description:
 * 24. 两两交换链表中的节点
 * <p>
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class Question0024 {
    public ListNode swapPairs(ListNode head) {
        if (head != null && head.next != null) {
            ListNode next = head.next;
            head.next = swapPairs(next.next);

            next.next = head;
            return next;
        }

        return head;
    }
}
