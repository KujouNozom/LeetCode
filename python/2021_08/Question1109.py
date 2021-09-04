# 1109. 航班预订统计
from itertools import accumulate
from typing import List


class Solution:
    def corpFlightBookings(self, bookings: List[List[int]], n: int) -> List[int]:
        diff = [0] * (n + 1)
        for booking in bookings:
            value = booking[2]
            diff[booking[0] - 1] += value
            diff[booking[1]] -= value
        return list(accumulate(diff))[:n]
