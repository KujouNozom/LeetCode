# 664. 奇怪的打印机 [动态规划]
class Solution:
    def strangePrinter(self, s: str) -> int:
        length = len(s)
        dp = [[1] * length for _ in range(length)]
        for i in range(length - 1, -1, -1):
            for j in range(i, length):
                if s[i] == s[j]:
                    dp[i][j] = dp[i][j - 1]
                else:
                    min_count = length
                    for k in range(i, j):
                        min_count = min(min_count, dp[i][k] + dp[k + 1][j])

                    dp[i][j] = min_count

        return dp[0][length - 1]