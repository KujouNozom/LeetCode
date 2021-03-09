# 1047. 删除字符串中的所有相邻重复项 [栈]
class Solution:
    def removeDuplicates(self, S: str) -> str:
        stack = []
        for temp in S:
            stack.pop() if stack and stack[-1] == temp else stack.append(temp)
        return ''.join(stack)