# 516. 最长回文子序列 [动态规划]
class Solution:
    def longestPalindromeSubseq(self, s: str) -> int:
        length = len(s)
        dp = [[1] * length for _ in range(length)]
        for i in range(length - 1, -1, -1):
            for j in range(i + 1, length):
                if i + 1 == j and s[i] == s[j]:
                    dp[i][j] = 2
                else:
                    dp[i][j] = dp[i + 1][j - 1] + 2 if s[i] == s[j] else max(dp[i + 1][j - 1], dp[i][j - 1],
                                                                             dp[i + 1][j])

        return dp[0][length - 1]
