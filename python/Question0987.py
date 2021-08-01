# 987. 二叉树的垂序遍历 [BFS,Hash]
import collections
from typing import List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def verticalTraversal(self, root: TreeNode) -> List[List[int]]:
        cols_nums = collections.defaultdict(list)
        queue = [(root, 0, 0)]
        while queue:
            temp = []
            node, row, col = queue.pop()
            cols_nums[col].append((row, node.val))
            if node.right:
                queue.append((node.right, row + 1, col + 1))
            if node.left:
                queue.append((node.left, row + 1, col - 1))

        ans = []
        cols = sorted(cols_nums.keys())
        for col in cols:
            ans.append([data[1] for data in list(sorted(cols_nums[col]))])
        return ans
