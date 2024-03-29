# 1310. 子数组异或查询 [前缀和]
from typing import List


class Solution:
    def xorQueries(self, arr: List[int], queries: List[List[int]]) -> List[int]:
        xors = [0]
        for num in arr:
            xors.append(xors[-1] ^ num)

        ans = list()
        for left, right in queries:
            ans.append(xors[left] ^ xors[right + 1])

        return ans
