# 421. 数组中两个数的最大异或值 [位运算]
from typing import List


class TreeNode:
    def __init__(self, left=None, right=None):
        self.left = left
        self.right = right


class DictTree:
    def __init__(self):
        self.root = TreeNode()

    def add(self, value: int):
        current = self.root
        for index in range(30, -1, -1):
            if value >> index & 1:
                if not current.right:
                    current.right = TreeNode()
                current = current.right
            else:
                if not current.left:
                    current.left = TreeNode()
                current = current.left

    def get_max_value(self, value: int) -> int:
        ans = 0
        current = self.root
        for index in range(30, -1, -1):
            if value >> index & 1 and current.left:
                current = current.left
                ans = ans * 2 + 1
            elif not value >> index & 1 and current.right:
                current = current.right
                ans = ans * 2 + 1
            else:
                ans = ans * 2
                current = current.left if current.left else current.right
        return ans


class Solution:
    def findMaximumXOR(self, nums: List[int]) -> int:
        tree = DictTree()
        for num in nums:
            tree.add(num)
        ans = -1
        for num in nums:
            ans = max(ans, tree.get_max_value(num))
        return ans
