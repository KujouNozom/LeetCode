# 781. 森林中的兔子 [数学，Hash]
import collections
from typing import List


class Solution:
    def numRabbits(self, answers: List[int]) -> int:
        values = dict(collections.Counter(answers))
        ans = 0
        for number, count in values.items():
            temp_count = count // (number + 1) + (1 if count % (number + 1) else 0)
            ans += temp_count * (number + 1)
        return ans


Solution().numRabbits([1, 0, 0, 0])
