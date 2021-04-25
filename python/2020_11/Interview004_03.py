from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def listOfDepth(self, tree: TreeNode) -> List[ListNode]:
        level = []
        ans = []
        level.append(tree)

        while level:
            head = ListNode(0)
            temp_node = head
            temp_level = []

            for node in level:
                temp_node.next = ListNode(node.val)
                temp_node = temp_node.next
                if node.left:
                    temp_level.append(node.left)
                if node.right:
                    temp_level.append(node.right)

            ans.append(head.next)
            level = temp_level
        return ans
