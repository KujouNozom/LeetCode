# 1711. 大餐计数 [Hash]
import collections
from typing import List


class Solution:
    def countPairs(self, deliciousness: List[int]) -> int:
        valid_list = [2 ** index for index in range(22)]
        value_indexes = collections.defaultdict(int)
        ans = 0
        mod = 10 ** 9 + 7
        for delicious in deliciousness:
            for valid in valid_list:
                ans = (ans + value_indexes[valid - delicious]) % mod
            value_indexes[delicious] = value_indexes[delicious] + 1

        return ans
