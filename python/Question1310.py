# 1310. 子数组异或查询 [前缀和，位运算]
from typing import List


class Solution:
    def xorQueries(self, arr: List[int], queries: List[List[int]]) -> List[int]:
        pre_sum = [0]
        for num in arr:
            pre_sum.append(pre_sum[-1] ^ num)
        return [pre_sum[query[1] + 1] ^ pre_sum[query[0]] for query in queries]
