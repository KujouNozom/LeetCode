# 730. 统计不同回文子序列 [动态规划]
class Solution:
    def countPalindromicSubsequences(self, S: str) -> int:
        def get_indexes_in_mid(i: int, j: int) -> list:
            indexes = char_indexes[S[i]]
            index_i = indexes.index(i)
            index_j = indexes.index(j)
            return indexes[index_i + 1: index_j]

        def get_count(i: int, j: int) -> int:
            if dp[i][j]:
                return dp[i][j]

            ans = 0
            if i <= j:
                if S[i] == S[j]:
                    indexes_in_mid = get_indexes_in_mid(i, j)
                    if len(indexes_in_mid) == 0:
                        ans = get_count(i + 1, j - 1) * 2 + 2
                    elif len(indexes_in_mid) == 1:
                        ans = get_count(i + 1, j - 1) * 2 + 1
                    elif len(indexes_in_mid) >= 2:
                        ans = get_count(i + 1, j - 1) * 2 - get_count(indexes_in_mid[0] + 1, indexes_in_mid[-1] - 1)
                else:
                    ans = get_count(i, j - 1) + get_count(i + 1, j) - get_count(i + 1, j - 1)

            dp[i][j] = (ans % mod_value) if ans >= 0 else (ans + mod_value)
            return dp[i][j]

        length = len(S)
        dp = []
        for index in range(length):
            temp = [0] * length
            temp[index] = 1
            dp.append(temp)

        char_indexes = collections.defaultdict(list)
        for index, char in enumerate(S):
            char_indexes[char].append(index)

        mod_value = 10 ** 9 + 7
        return get_count(0, length - 1)