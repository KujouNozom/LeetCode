# 剑指 Offer 15. 二进制中1的个数 [布莱尔算法]
class Solution:
    def hammingWeight(self, n: int) -> int:
        count = 0
        while n != 0:
            n = n & (n - 1)
            count += 1

        return count
