package com.sxg.leetcode.question;

import com.sxg.leetcode.entity.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: Question0089
 * @Author: Su_N
 * @Date: 2020/12/10 22:56
 * @Description: 83. 删除排序链表中的重复元素
 *
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 *
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */
public class Question0083 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        Set<Integer> set = new HashSet<>();
        ListNode temp = head;
        set.add(head.val);
        while (temp != null && temp.next != null) {
            if (set.contains(temp.next.val)) {
                temp.next = temp.next.next;
            } else {
                set.add(temp.next.val);
                temp = temp.next;
            }
        }

        return head;
    }
}
