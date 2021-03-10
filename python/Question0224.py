# 224. 基本计算器 [栈]
class Solution:
    def calculate(self, s: str) -> int:
        value_stack = []
        for c in s.replace(' ', ''):
            if c == ')':
                cal = []
                temp = value_stack.pop()
                while temp != '(':
                    cal.append(temp)
                    temp = value_stack.pop()
                c = str(eval(''.join(reversed(cal))))

            value_stack.append(c)
        return eval(''.join(value_stack))
