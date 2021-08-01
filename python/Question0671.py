# 671. 二叉树中第二小的节点 [二叉树，DFS]
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def findSecondMinimumValue(self, root: TreeNode) -> int:
        def dfs(root: TreeNode):
            nonlocal ans, root_value
            if ans != root_value and root.val > ans:
                return
            if root.left:
                dfs(root.left)
            if root.right:
                dfs(root.right)
            if root.val > root_value:
                ans = root.val

        root_value = root.val
        ans = root_value
        dfs(root)
        return ans if ans != root_value else -1
