# 191. 位1的个数 [位运算]
class Solution:
    def hammingWeight(self, n: int) -> int:
        return str(bin(n)).count('1')
