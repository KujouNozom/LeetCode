package com.sxg.leetcode.finished.no0051_0100;

import com.sxg.leetcode.entity.ListNode;

/**
 * @ClassName: Question0061
 * @Author: Su_N
 * @Date: 2020/4/28 14:12
 * @Description: 先构成循环链表，然后移动头指针位置
 * 61. 旋转链表
 * <p>
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * <p>
 * 示例 2:
 * <p>
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
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

        if(k % count == 0){
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
