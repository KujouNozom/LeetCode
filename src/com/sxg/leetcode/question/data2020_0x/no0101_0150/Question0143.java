package com.sxg.leetcode.question.data2020_0x.no0101_0150;

import com.sxg.leetcode.entity.ListNode;

/**
 * @ClassName: Question0143
 * @Author: Su_N
 * @Date: 2020/6/6 19:35
 * @Description: 双指针
 * 一个快指针，一个慢指针，快指针，一次2步，慢指针一次1步，快指针到头的时候慢指针在中间
 * 从中间分隔链表，后半部分倒序，然后遍历前半部分，每隔一个插入一个反序的后的指针
 * <p>
 * 143. 重排链表
 * <p>
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例 1:
 * <p>
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * <p>
 * 示例 2:
 * <p>
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 */
public class Question0143 {
    public static void main(String[] args) {
        Question0143 demo = new Question0143();
        ListNode head = new ListNode(1);
        ListNode current = head;
        for (int index = 1; index < 6; index++) {
            ListNode temp = new ListNode(index + 1);
            current.next = temp;
            current = temp;
        }
        demo.reorderList(head);
    }

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode fast = head;
        ListNode slow = head;

        // 找到中间点
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode tail = slow.next;
        slow.next = null;

        // 反序后半部分
        if (tail != null) {
            ListNode tailPre = null;
            while (tail != null) {
                ListNode tailNext = tail.next;

                tail.next = tailPre;

                tailPre = tail;
                tail = tailNext;
            }
            tail = tailPre;
        }

        ListNode index = head;
        while (tail != null) {
            ListNode tempTail = tail.next;
            tail.next = index.next;
            index.next = tail;
            index = tail.next;
            tail = tempTail;
        }
    }
}
