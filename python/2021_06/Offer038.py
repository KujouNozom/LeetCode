# 剑指 Offer 38. 字符串的排列 [回溯]
from typing import List


class Solution:
    def permutation(self, s: str) -> List[str]:
        def backtrace(values: List[str], count: int):
            if count == length:
                ans.add(''.join(values))
                return

            for index in range(length):
                if valid[index]:
                    valid[index] = False
                    values.append(s[index])
                    backtrace(values, count + 1)
                    values.pop()
                    valid[index] = True

        length = len(s)
        ans = set()
        valid = [True] * length
        backtrace([], 0)
        return list(ans)
