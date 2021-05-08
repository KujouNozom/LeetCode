# 1315. 祖父节点值为偶数的节点和 [深度搜索]
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def sumEvenGrandparent(self, root: TreeNode) -> int:
        ans = 0

        def dfs(root: TreeNode):
            if not root:
                return
            if root.left:
                dfs(root.left)
            if root.right:
                dfs(root.right)

            if root.val % 2 == 0:
                nonlocal ans
                if root.left:
                    if root.left.left:
                        ans = ans + root.left.left.val
                    if root.left.right:
                        ans = ans + root.left.right.val
                if root.right:
                    if root.right.left:
                        ans = ans + root.right.left.val
                    if root.right.right:
                        ans = ans + root.right.right.val

        dfs(root)
        return ans
