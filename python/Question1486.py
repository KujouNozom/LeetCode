# 1486. 数组异或操作 [位运算]
from functools import reduce


class Solution:
    def xorOperation(self, n: int, start: int) -> int:
        return reduce(lambda x, y: x ^ (start + y * 2), range(1, n), start)
