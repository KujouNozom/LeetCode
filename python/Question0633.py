# 633. 平方数之和 [数学]
import math


class Solution:
    def judgeSquareSum(self, c: int) -> bool:
        sqrt_c = int(math.sqrt(c))
        for i in range(sqrt_c + 1):
            value = math.sqrt(c - i * i)
            if value == int(value):
                return True
        return False
