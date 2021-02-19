package com.sxg.leetcode.question.data2020_0x.no0051_0100;

import com.sxg.leetcode.entity.ListNode;

/**
 * @ClassName: Question0092
 * @Author: Su_N
 * @Date: 2020/5/19 7:49
 * @Description: 使用多个指针
 * tempHead 记录 m 前面一个节点，tail 记录m节点
 * 之后循环遍历 m 到 n 的节点
 * pre 记录当前节点前面一个，cur 记录 pre 后面一个节点，交换 cur 和 pre 两个节点的关系（需要使用一个 temp 节点,记录 cur 下一个节点）
 * 循环结束的时候，需要翻反转的列表已经反装完毕，tempHead.next 设置为 pre,tail.next 设置为 cur
 * 92. 反转链表 II
 * <p>
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */
public class Question0092 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }

        ListNode tempHead = new ListNode(0);
        tempHead.next = head;

        for (int index = 1; index < m; index++) {
            tempHead = tempHead.next;
        }

        ListNode tail = tempHead.next;
        ListNode pre = tail;
        ListNode cur = tail.next;

        for (int index = m; index < n; index++) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        tempHead.next = pre;
        tail.next = cur;

        if (m == 1) {
            return tempHead.next;
        }
        return head;
    }
}
