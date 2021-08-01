# 374. 猜数字大小 [二分查找]
def guess():
    pass


class Solution:
    def guessNumber(self, n: int) -> int:
        left, right = 1, n
        while left <= right:
            mid = (left + right) // 2
            if guess(mid) == 0:
                return mid
            if guess(mid) == 1:
                left = mid + 1
            else:
                right = mid - 1
