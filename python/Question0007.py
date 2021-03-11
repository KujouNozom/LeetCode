# 0007. 整数反转
class Solution:
    def reverse(self, x: int) -> int:
        x_str = str(x)
        flag = x_str[0] == '-'
        if flag:
            x_str = x_str[1:]

        x_str = reversed(x_str)
        value = '-' if flag else ''
        value += ''.join(x_str)
        int_value = int(value)
        return int_value if (2 ** 31 - 1) >= int_value >= -(2 ** 31) else 0