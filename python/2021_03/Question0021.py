# 21. 合并两个有序链表 [链表]
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        ans = ListNode()
        head = ans
        while l1 and l2:
            if l1.val <= l2.val:
                head.next = l1
                l1 = l1.next
                head = head.next
            else:
                head.next = l2
                l2 = l2.next
                head = head.next

        head.next = l1 if l1 else l2
        return ans.next
