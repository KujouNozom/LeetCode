package com.sxg.leetcode.question.data2020_04;

import com.sxg.leetcode.entity.ListNode;

/**
 * @ClassName: Question0061
 * @Author: Su_N
 * @Date: 2020/4/28 14:12
 * @Description: 61. 旋转链表 [先构成循环链表，然后移动头指针位置]
 */
public class Question0061 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int count = 1;
        ListNode temp = head;
        while (temp.next != null) {
            count++;
            temp = temp.next;
        }

        if (k % count == 0) {
            return head;
        }

        temp.next = head;

        for (int index = 0; index < count - k % count; index++) {
            head = head.next;
            temp = temp.next;
        }

        temp.next = null;

        return head;
    }
}
