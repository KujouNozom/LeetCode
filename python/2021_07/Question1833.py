# 1833. 雪糕的最大数量 [贪心，排序]
import collections
from typing import List


class Solution:
    def maxIceCream(self, costs: List[int], coins: int) -> int:
        cost_count = collections.Counter(costs)
        cost_list = sorted(cost_count.keys())
        ans = 0
        for cost in cost_list:
            if coins >= cost:
                count = min(coins // cost, cost_count[cost])
                ans += count
                coins -= count * cost
            else:
                break

        return ans
