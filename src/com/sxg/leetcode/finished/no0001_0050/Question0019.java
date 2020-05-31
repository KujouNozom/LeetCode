package com.sxg.leetcode.finished.no0001_0050;

import com.sxg.leetcode.entity.ListNode;

/**
 * @ClassName: Question0019
 * @Author: Su_N
 * @Date: 2020/4/27 22:06
 * @Description:两个指针 相差n
 * 19. 删除链表的倒数第N个节点
 * <p>
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * <p>
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * <p>
 * 你能尝试使用一趟扫描实现吗？
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
