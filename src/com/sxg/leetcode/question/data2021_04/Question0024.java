package com.sxg.leetcode.question.data2021_04;

import com.sxg.leetcode.entity.ListNode;

/**
 * @ClassName: Question0024
 * @Author: Su_N
 * @Date: 2020/4/27 22:44
 * @Description: 24. 两两交换链表中的节点
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
