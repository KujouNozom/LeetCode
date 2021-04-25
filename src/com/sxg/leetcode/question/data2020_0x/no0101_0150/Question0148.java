package com.sxg.leetcode.question.data2020_0x.no0101_0150;

import com.sxg.leetcode.entity.ListNode;

/**
 * @ClassName: Question0148
 * @Author: Su_N
 * @Date: 2020/6/10 21:37
 * @Description: 因为时间要求是O(n log n) 因此使用归并排序
 * <p>
 * <p>
 * 148. 排序链表
 * <p>
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * <p>
 * 示例 2:
 * <p>
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */
public class Question0148 {
    public static void main(String[] args) {
        Question0148 demo = new Question0148();

        int[] dd = {14, 12, 15, 13, 11, 16};

        ListNode head = new ListNode(0);
        ListNode temp = head;
        for (int tt : dd) {
            ListNode ttt = new ListNode(tt);
            temp.next = ttt;
            temp = temp.next;
        }

        ListNode result = demo.sortList(head.next);

        System.out.println(result);
    }

    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head != null && head.next != null) {
            ListNode mid = getMid(head);

            ListNode part1 = sortList(head);
            ListNode part2 = sortList(mid);

            ListNode tempHead = new ListNode(0);
            ListNode temp = tempHead;

            while (part1 != null && part2 != null) {
                if (part1.val > part2.val) {
                    temp.next = part2;
                    part2 = part2.next;
                } else {
                    temp.next = part1;
                    part1 = part1.next;
                }
                temp = temp.next;
            }

            if (part1 == null) {
                temp.next = part2;
            } else {
                temp.next = part1;
            }
            return tempHead.next;
        }

        return head;

    }

    private ListNode getMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        // 找到中间点
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode result = slow.next;
        slow.next = null;
        return result;
    }
}
