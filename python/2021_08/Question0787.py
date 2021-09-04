# 787. K 站中转内最便宜的航班 [动态规划]
from typing import List


class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        dp = [[float('inf')] * (n + 1) for _ in range(k + 2)]
        dp[0][src] = 0
        for i in range(1, k + 2):
            for (flight_src, flight_dst, flight) in flights:
                dp[i][flight_dst] = min(dp[i][flight_dst], dp[i - 1][flight_src] + flight)

        ans = min([dp[i][dst] for i in range(k + 2)])
        return ans if ans != float('inf') else -1
