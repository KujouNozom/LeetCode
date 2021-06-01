# 231. 2 的幂 [位运算，布莱恩算法]
class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        return n != 0 and not n & (n - 1)
