# 872. 叶子相似的树 [递归]
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def get_next_node(root: TreeNode):
    stack = []
    stack.append(root)
    while stack:
        current = stack.pop()
        if not (current.left or current.right):
            yield current.val

        if current.right:
            stack.append(current.right)
        if current.left:
            stack.append(current.left)


class Solution:
    def leafSimilar(self, root1: TreeNode, root2: TreeNode) -> bool:
        leaf_bs = get_next_node(root2)
        try:
            for leaf_a in get_next_node(root1):
                leaf_b = next(leaf_bs)
                if leaf_a != leaf_b:
                    return False
        except StopIteration:
            return False

        try:
            next(leaf_bs)
        except StopIteration:
            return True
        return False
