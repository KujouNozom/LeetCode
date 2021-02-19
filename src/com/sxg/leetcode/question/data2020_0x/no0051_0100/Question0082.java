package com.sxg.leetcode.question.data2020_0x.no0051_0100;

import com.sxg.leetcode.entity.ListNode;

/**
 * @ClassName: Question0082
 * @Author: Su_N
 * @Date: 2020/5/13 19:06
 * @Description: 双指针法
 * 首先在头部前面添加一个假加点，这样不同特殊处理头部
 * 两个指针，一个 index 起始位于假节点，一个 delete 位于原头结点
 * 1.判断 delete 的值和 delete.next 的值是否相等
 * 2.如果相等的话，需要删除，判断 delete = delete.next.不断循环，直到两个值不相等，这样可以获取需要删除的当前值的所有元素
 * 3.删除元素 index.next = delete.next，移动指针 delete = delete.next
 * 4.如果 delete 的值和 delete.next 不相等，则元素不需要删除,移动指针 index = delete, delete = delete.next
 * <p>
 * index.next != null && index.next.next != null 的时候
 * 判断 index 的值和 index.next 的值是否相等，相等的话删除 index.next(index.next = index.next.next)
 * 82. 删除排序链表中的重复元素 II
 * <p>
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * <p>
 * 示例 2:
 * <p>
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 */
public class Question0082 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        ListNode tempHead = new ListNode(0);
        tempHead.next = head;


        ListNode index = tempHead;
        ListNode delete = tempHead.next;
        while (delete != null) {
            if (delete.next != null && delete.val == delete.next.val) {
                while (delete != null && delete.next != null && delete.val == delete.next.val) {
                    delete = delete.next;
                }
                index.next = delete.next;
                delete = delete.next;
            } else {
                index = index.next;
                delete = delete.next;
            }
        }


        return tempHead.next;
    }
}
