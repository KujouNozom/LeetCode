# 331. 验证二叉树的前序序列化 [栈]
class Solution:
    def isValidSerialization(self, preorder: str) -> bool:
        stack = []
        for c in preorder.split(','):
            stack.append(c)
            while stack and len(stack) >= 3 and stack[-1] == '#' and stack[-2] == '#':
                if stack[-3] == '#':
                    return False
                else:
                    stack = list(stack[:-3])
                    stack.append('#')

        return not stack or (len(stack) == 1 and stack[0] == '#')