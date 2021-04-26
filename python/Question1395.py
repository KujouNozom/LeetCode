# 1395. 统计作战单位数 [数组]
from typing import List


def get_count(rating: List[int], j: int) -> int:
    global length
    j_rating = rating[j]

    i_asc_count = 0
    i_desc_count = 0
    for i in range(0, j):
        if rating[i] < j_rating:
            i_asc_count += 1
        else:
            i_desc_count += 1

    k_asc_count = 0
    k_desc_count = 0
    for k in range(j + 1, length):
        if rating[k] > j_rating:
            k_asc_count += 1
        else:
            k_desc_count += 1

    return i_asc_count * k_asc_count + i_desc_count * k_desc_count


length = 0


class Solution:
    def numTeams(self, rating: List[int]) -> int:
        global length
        length = len(rating)
        ans = 0
        for j in range(1, length - 1):
            ans += get_count(rating, j)
        return ans
