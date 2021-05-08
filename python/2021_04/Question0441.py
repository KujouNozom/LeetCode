# 441. 排列硬币 [二分查找]
class Solution:
    def arrangeCoins(self, n: int) -> int:
        def get_value(k: int) -> int:
            if n:
                return (1 + k) * k / 2
            return 0

        low, high = 0, int(math.sqrt(2 * n))
        while low <= high:
            mid = (low + high) // 2
            value = get_value(mid)
            if value == n:
                return mid
            if value < n:
                low = mid + 1
            else:
                high = mid - 1

        return high