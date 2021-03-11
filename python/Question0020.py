# 20. 有效的括号 [栈]
class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        left = ['{', '[', '(']
        right = ['}', ']', ')']
        for temp in s:
            if temp in right:
                if not stack or left.index(stack.pop()) != right.index(temp):
                    return False
            else:
                stack.append(temp)
        return not stack