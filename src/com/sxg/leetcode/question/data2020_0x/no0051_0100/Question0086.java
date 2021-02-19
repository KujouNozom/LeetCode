package com.sxg.leetcode.question.data2020_0x.no0051_0100;

import com.sxg.leetcode.entity.ListNode;

/**
 * @ClassName: Question0086
 * @Author: Su_N
 * @Date: 2020/5/13 19:07
 * @Description: 双指针法
 * 使用两个指针，一个存放大于等于x的，一个存放小于x的，然后把两个链接到一起
 * 注意 最后要将 maxIndex.next 置为 null,否则可能出现循环链表
 * 86. 分隔链表
 * <p>
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * <p>
 * 你应当保留两个分区中每个节点的初始相对位置。
 * <p>
 * 示例:
 * <p>
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 */
public class Question0086 {
    public ListNode partition(ListNode head, int x) {
        ListNode maxHead = new ListNode(0);
        ListNode minHead = new ListNode(0);
        ListNode maxIndex = maxHead;
        ListNode minIndex = minHead;

        while (head != null) {
            if (head.val < x) {
                minIndex.next = head;
                minIndex = minIndex.next;
            } else {
                maxIndex.next = head;
                maxIndex = maxIndex.next;
            }
            head = head.next;
        }

        maxIndex.next = null;
        minIndex.next = maxHead.next;

        return minHead.next;
    }
}
