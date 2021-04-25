# 1720. 解码异或后的数组 [位运算]
from typing import List


class Solution:
    def decode(self, encoded: List[int], first: int) -> List[int]:
        ans = [first]
        for value in encoded:
            ans.append(ans[-1] ^ value)
        return ans
