package com.sxg.leetcode.question.data2020_0x.no0201_0250;

import com.sxg.leetcode.entity.ListNode;

import java.util.Stack;

/**
 * @ClassName: com.sxg.leetcode.question.data2020_0x.no0201_0250.Question0234
 * @Author: Su_N
 * @Date: 2020/10/24 13:20
 * @Description: 快慢指针
 * 快慢指针，找到中间点，慢指针数据入栈，之后慢指针继续遍历和栈对比
 * 234. 回文链表
 *
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 *
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 *
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class Question0234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        Stack<Integer> stack = new Stack<>();
        ListNode slow = head;
        ListNode fast = head;
        stack.push(head.val);
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            stack.push(slow.val);
        }

        if (fast.next == null) {
            stack.pop();
        }

        slow = slow.next;
        while (slow != null && !stack.isEmpty()) {
            if (slow.val != stack.pop()) {
                return false;
            } else {
                slow = slow.next;
            }
        }

        return slow == null && stack.isEmpty();
    }
}
