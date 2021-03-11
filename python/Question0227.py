# 227. 基本计算器 II [栈]
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
                    cal_value = ''.join(reversed(cal)).replace("/", "//")

                c = str(eval(cal_value))

            value_stack.append(c)
        return eval(''.join(value_stack).replace("/", "//"))
