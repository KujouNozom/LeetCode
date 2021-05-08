# 87. 扰乱字符串 [动态规划，DFS]
import collections
import functools


@functools.lru_cache(None)
def function(s1: str, s2: str) -> bool:
    if s1 == s2:
        return True
    if collections.Counter(s1) != collections.Counter(s2):
        return False

    for i in range(1, len(s1)):
        s11, s12 = s1[:i], s1[i:]
        if (function(s11, s2[:i]) and function(s12, s2[i:])) or (function(s12, s2[:-i]) and function(s11, s2[-i:])):
            return True
    return False


class Solution:
    def isScramble(self, s1: str, s2: str) -> bool:
        return function(s1, s2)
