# 678. 有效的括号字符串 [动态规划]
class Solution:
    def checkValidString(self, s: str) -> bool:
        min_count, max_count = 0, 0
        for c in s:
            if c == '(':
                min_count, max_count = min_count + 1, max_count + 1
            elif c == '*':
                if min_count > 0:
                    min_count = min_count - 1
                max_count = max_count + 1
            else:
                if min_count > 0:
                    min_count = min_count - 1
                max_count = max_count - 1
                if max_count < 0:
                    return False
        return min_count == 0