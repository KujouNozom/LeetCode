# 226. 翻转二叉树 [深度搜索]
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def invertTree(self, root: TreeNode) -> TreeNode:
        def dfs(root: TreeNode):
            root.left, root.right = root.right, root.left
            if root.left:
                dfs(root.left)
            if root.right:
                dfs(root.right)

        if root:
            dfs(root)
        return root