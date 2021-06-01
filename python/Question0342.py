# 342. 4的幂 [位运算]
class Solution:
    def isPowerOfFour(self, n: int) -> bool:
        return n != 0 and not n & (n - 1) and not n & 2863311530
