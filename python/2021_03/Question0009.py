# 0009. 回文数
class Solution:
    def isPalindrome(self, x: int) -> bool:
        value_str = str(x)
        if value_str[0] == '-':
            return False
        value = int(''.join(reversed(value_str)))
        return x == value