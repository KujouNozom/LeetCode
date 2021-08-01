# 863. 二叉树中所有距离为 K 的结点 [二叉树，DFS]
from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def distanceK(self, root: TreeNode, target: TreeNode, k: int) -> List[int]:
        def get_parent(parent: TreeNode, current: TreeNode):
            nonlocal parent_tree

            parent_tree[current.val] = parent
            if current.left:
                get_parent(current, current.left)
            if current.right:
                get_parent(current, current.right)

        def get_value(current: TreeNode, from_node: TreeNode, k: int):
            nonlocal parent_tree, ans

            if k == 0 and current:
                ans.append(current.val)
            else:
                if parent_tree[current.val] and parent_tree[current.val] != from_node:
                    get_value(parent_tree[current.val], current, k - 1)
                if current.left and current.left != from_node:
                    get_value(current.left, current, k - 1)
                if current.right and current.right != from_node:
                    get_value(current.right, current, k - 1)

        parent_tree = {}
        get_parent(None, root)

        ans = []
        get_value(target, None, k)

        return ans
