# 940. 不同的子序列 II [动态规划]
import collections


class Solution:
    def distinctSubseqII(self, S: str) -> int:
        length = len(S)
        indexes = collections.defaultdict(list)
        for index, world in enumerate(S):
            indexes[world].append(index)

        dp = [0] * (length + 1)
        mod_value = 10 ** 9 + 7
        for index in range(length):
            index_list = indexes[S[index]]
            pre_index = index_list.index(index)
            value = dp[index - 1] * 2 + (1 if pre_index == 0 else (- dp[index_list[pre_index - 1] - 1]))
            dp[index] = value % mod_value
        return dp[length - 1]
