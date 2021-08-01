# 278. 第一个错误的版本 [二分查找]

def isBadVersion(data) -> bool:
    pass


class Solution:
    def firstBadVersion(self, n):
        left, right = 0, n - 1
        ans = n
        while left < right:
            mid = (left + right) // 2
            if isBadVersion(mid):
                right = mid - 1
                ans = mid
            else:
                left = mid + 1
        return ans
