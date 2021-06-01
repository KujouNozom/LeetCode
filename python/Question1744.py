from typing import List


class Solution:
    def canEat(self, candiesCount: List[int], queries: List[List[int]]) -> List[bool]:
        pre_count_indexes = [0]
        for candieCount in candiesCount:
            pre_count_indexes.append(pre_count_indexes[-1] + candieCount)

        ans = []
        for query in queries:
            favorite_type, favorite_day, daily_cap = query
            current_day_min, current_day_max = favorite_day + 1, (favorite_day + 1) * daily_cap
            current_candie_min, current_candie_max = pre_count_indexes[favorite_type] + 1, pre_count_indexes[
                favorite_type + 1]
            ans.append(current_candie_max >= current_day_min and current_candie_min <= current_day_max)
        return ans


print(Solution().canEat(candiesCount=[5, 2, 6, 4, 1],
                        queries=[[0, 4, 2], [4, 10, 3], [3, 10, 100], [4, 100, 30], [1, 3, 1]]))
