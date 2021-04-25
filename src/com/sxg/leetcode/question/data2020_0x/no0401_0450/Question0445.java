package com.sxg.leetcode.question.data2020_0x.no0401_0450;

import com.sxg.leetcode.entity.ListNode;

import java.util.Stack;

/**
 * @ClassName: Question0445
 * @Author: Su_N
 * @Date: 2020/9/18 20:42
 * @Description: 445. 两数相加 II
 *
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 *
 *
 * 进阶：
 *
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 *
 *
 *
 * 示例：
 *
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 */
public class Question0445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        while (l1 != null) {
            stack1.add(l1.val);
            l1 = l1.next;
        }

        Stack<Integer> stack2 = new Stack<>();
        while (l2 != null) {
            stack2.add(l2.val);
            l2 = l2.next;
        }

        ListNode current = null;
        int flag = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || flag != 0) {
            int sum = (stack1.isEmpty() ? 0 : stack1.pop()) + (stack2.isEmpty() ? 0 : stack2.pop()) + flag;
            ListNode pre = new ListNode(sum % 10);
            pre.next = current;
            current = pre;
            flag = sum / 10;
        }

        return current;
    }
}
