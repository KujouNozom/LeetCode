package com.sxg.leetcode.question.data2020_0x.no0101_0150;

import com.sxg.leetcode.entity.ListNode;

/**
 * @ClassName: Question0142
 * @Author: Su_N
 * @Date: 2020/6/5 18:50
 * @Description: 双指针法，一个步进1，一个步进2，两个重合的时候就是有环
 * 此时记录这个相遇点，再使用两个指针，一个指向相遇点，一个指向头指针，两个步进都是1，相依的时候 就是环的第一个节点
 * 证明：
 * 进环之前的距离x,进环开始到相遇点距离y，相遇点到进环距离z
 * 因为步进不同，所以相遇到时候肯定快的一个已经走完一圈，慢的还没由走完一圈,慢在走的路程是 x+y，快的走的是x+y+z+y
 * 2*(x + y) = x+y+z+y  ==>  2x + 2y = x + 2y + z  ==>  x = z
 * 第二轮的时候，进环之前的距离x == 相遇点到进环距离z，所以两个指针在进环处相遇
 * 142. 环形链表 II
 * <p>
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * <p>
 * 说明：不允许修改给定的链表。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [1,2], pos = 0
 * 输出：tail connects to node index 0
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * <p>
 * 示例 3：
 * <p>
 * 输入：head = [1], pos = -1
 * 输出：no cycle
 * 解释：链表中没有环。
 * <p>
 * <p>
 * <p>
 * 进阶：
 * 你是否可以不用额外空间解决此题？
 */
public class Question0142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode meetNode = getMeetNode(head);
        if (meetNode == null) {
            return null;
        }

        while (head != meetNode) {
            head = head.next;
            meetNode = meetNode.next;
        }

        return meetNode;
    }

    private ListNode getMeetNode(ListNode head) {
        ListNode first = head;
        ListNode slow = head;

        while (first != null && first.next != null) {
            slow = slow.next;
            first = first.next.next;
            if (first == slow) {
                return first;
            }
        }

        return null;
    }
}
