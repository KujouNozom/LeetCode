package com.sxg.leetcode.question.data2020_04;

import com.sxg.leetcode.entity.ListNode;

/**
 * @ClassName: Question0019
 * @Author: Su_N
 * @Date: 2020/4/27 22:06
 * @Description: 19. 删除链表的倒数第N个节点 [两个指针,相差n]
 */
public class Question0019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode nodeNext = head;
        for (int index = 0; index < n; index++) {
            nodeNext = nodeNext.next;
        }

        ListNode nodePre = head;
        if (nodeNext != null) {
            while (nodeNext.next != null) {
                nodePre = nodePre.next;
                nodeNext = nodeNext.next;
            }
            nodePre.next = nodePre.next.next;

        } else {
            head = head.next;
        }

        return head;
    }
}
