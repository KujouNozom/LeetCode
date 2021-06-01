# 993. 二叉树的堂兄弟节点 [层序遍历]
from typing import List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        def get_level_info(nodes: List[TreeNode]) -> dict:
            node_info = {}
            parent_node_info = {}
            result = {"node_info": node_info, "parent_node_info": parent_node_info}
            for node in nodes:
                if node.left:
                    node_info[node.left.val] = node.left
                    parent_node_info[node.left.val] = node.val
                if node.right:
                    node_info[node.right.val] = node.right
                    parent_node_info[node.right.val] = node.val
            return result

        temp = [root]
        while temp:
            next_level_nodes = get_level_info(temp)
            if next_level_nodes:
                node_info = next_level_nodes["node_info"]
                parent_info = next_level_nodes["parent_node_info"]
                values = node_info.keys()
                if x in values and y in values and parent_info[x] != parent_info[y]:
                    return True
            temp = node_info.values()
