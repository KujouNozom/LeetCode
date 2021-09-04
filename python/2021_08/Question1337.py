# 1337. 矩阵中战斗力最弱的 K 行 [二分查找]
from typing import List


def bin_search(data: list, start: int, end: int):
    ans = end + 1
    while start <= end:
        mid = (start + end) // 2
        if data[mid] == 0:
            ans = mid
            end = mid - 1
        else:
            start = mid + 1
    return ans


class Solution:
    def kWeakestRows(self, mat: List[List[int]], k: int) -> List[int]:
        length = len(mat[0]) - 1
        counts = [(bin_search(mat[index], 0, length), index) for index in range(len(mat))]
        counts.sort()
        return list([count[1] for count in counts])[:k]
