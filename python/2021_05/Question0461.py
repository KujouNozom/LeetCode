# 461. 汉明距离 [位运算，布莱恩算法]
class Solution:
    def hammingDistance(self, x: int, y: int) -> int:
        temp = x ^ y
        ans = 0
        while temp:
            temp = temp & (temp - 1)
            ans += 1
        return ans
