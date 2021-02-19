package com.sxg.leetcode.question.data2020_0x.no0101_0150;

import com.sxg.leetcode.entity.ListNode;

/**
 * @ClassName: Question0147
 * @Author: Su_N
 * @Date: 2020/6/9 23:00
 * @Description: 147. 对链表进行插入排序
 * <p>
 * 对链表进行插入排序。
 * <p>
 * <p>
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 * <p>
 * <p>
 * <p>
 * 插入排序算法：
 * <p>
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * <p>
 * 示例 2：
 * <p>
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */
public class Question0147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode resultHead = new ListNode(-Integer.MAX_VALUE);
        ListNode current = head;
        while (current != null) {
            ListNode currentCompare = resultHead;
            while (currentCompare.next != null && currentCompare.next.val < current.val) {
                currentCompare = currentCompare.next;
            }
            ListNode tempCurrent = current.next;
            current.next = currentCompare.next;
            currentCompare.next = current;
            current = tempCurrent;
        }

        return resultHead.next;
    }
}
