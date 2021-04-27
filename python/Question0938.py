# 938. 二叉搜索树的范围和 [中序遍历]
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def function(root: TreeNode, low: int, high: int) -> int:
    ans = 0
    if root.left:
        ans += function(root.left, low, high)

    if root.val > high:
        return ans
    if root.val >= low:
        ans += root.val

    if root.right:
        ans += function(root.right, low, high)
    return ans


class Solution:
    def rangeSumBST(self, root: TreeNode, low: int, high: int) -> int:
        return function(root, low, high)
