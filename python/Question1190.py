# 1190. 反转每对括号间的子串 [栈]
class Solution:
    def reverseParentheses(self, s: str) -> str:
        temp = ''
        stack = []
        for data in s:
            if data == '(':
                stack.append(temp)
                temp = ''
            elif data == ')':
                temp = stack.pop() + temp[::-1]
            else:
                temp += data

        return temp
