# 328.奇偶链表
# [中等]
# 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
# 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
# 示例
# 示例 1
# 输入: 1->2->3->4->5->NULL
# 输出: 1->3->5->2->4->NULL
# 示例 2
# 输入: 2->1->3->5->6->4->7->NULL
# 输出: 2->3->6->7->1->5->4->NULL
# 说明
# 应当保持奇数节点和偶数节点的相对顺序。
# 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
# 题解
# 我们使用两个链表，一个保存奇数节点，一个保存偶数节点
# 奇数链表 index1 初始值 head，偶数链表 index2 初始值 head.next
# 奇数节点的下一个值是 index2.next，我们将它添加到奇数链表 index1.next = index2.next。然后 index1 = index1.next。
# 这个时候偶数节点的下一个值是 index1.next，我们将它添加到偶数偶数链表 index2.next = index1.next，然后 index2 = index2.next。
# 遍历的终止条件是 index2 == null or index2.next == null


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def oddEvenList(self, head: ListNode) -> ListNode:
        if not head:
            return head

        temp_head1, temp_index1 = head, head
        temp_head2, temp_index2 = head.next, head.next
        while temp_index2 and temp_index2.next:
            temp_index1.next = temp_index2.next
            temp_index1 = temp_index1.next
            if temp_head1:
                temp_index2.next = temp_index1.next
                temp_index2 = temp_index2.next

        temp_index1.next = temp_head2

        return temp_head1
