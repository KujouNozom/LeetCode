# 1734. 解码异或后的排列 [位运算]
from functools import reduce
from typing import List


class Solution:
    def decode(self, encoded: List[int]) -> List[int]:
        n = len(encoded) + 1
        total_result = reduce(lambda x, y: x ^ y, [x for x in range(1, n + 1)])
        remove_first_result = reduce(lambda x, y: x ^ y, encoded[1::2])
        first_num = total_result ^ remove_first_result

        ans = [first_num]
        for value in encoded:
            ans.append(ans[-1] ^ value)

        return ans
