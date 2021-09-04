# 528. 按权重随机选择
from bisect import bisect_left
from itertools import accumulate
from random import random
from typing import List


class Solution:

    def __init__(self, w: List[int]):
        self.pre = list(accumulate(w))
        self.total = sum(w)

    def pickIndex(self) -> int:
        x = random.randint(1, self.total)
        return bisect_left(self.pre, x)