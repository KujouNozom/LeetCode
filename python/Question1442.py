# 1442. 形成两个异或相等数组的三元组数目 [位运算，前缀和]
from typing import List


class Solution:
    def countTriplets(self, arr: List[int]) -> int:
        pre_sum_indexes = [0]
        for num in arr:
            pre_sum_indexes.append(pre_sum_indexes[-1] ^ num)

        length = len(arr)
        ans = 0
        for i in range(length):
            for j in range(i + 1, length):
                if pre_sum_indexes[i] == pre_sum_indexes[j + 1]:
                    ans += (j - i)
        return ans
