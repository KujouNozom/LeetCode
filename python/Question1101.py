# 1011. 在 D 天内送达包裹的能力 [二分查找]
from typing import List


def check(weights: List[int], max_count: int, max_weight: int) -> bool:
    current_count = 1
    current_weight = 0

    for weight in weights:
        if current_count > max_count:
            return False

        if current_weight + weight <= max_weight:
            current_weight += weight
        else:
            current_count += 1
            current_weight = weight
    return current_count <= max_count


class Solution:
    def shipWithinDays(self, weights: List[int], D: int) -> int:
        high = sum(weights)
        low = max(weights)
        while low < high:
            mid = (low + high) // 2
            if check(weights, D, mid):
                high = mid
            else:
                low = mid + 1
        return high
