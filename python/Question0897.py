# 897. 递增顺序搜索树 [中序遍历]
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def increasingBST(self, root: TreeNode) -> TreeNode:

        def function(root: TreeNode):
            nonlocal temp
            if root.left:
                function(root.left)
            root.left = None
            temp.right = root
            temp = temp.right
            if root.right:
                function(root.right)

        temp = TreeNode(val=-1)
        ans = temp
        function(root)
        return ans.right
