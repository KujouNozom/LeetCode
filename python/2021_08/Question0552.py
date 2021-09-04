# 552. 学生出勤记录 II [动态规划]
class Solution:
    def checkRecord(self, n: int) -> int:
        mod_value = 10 ** 9 + 7

        dp = [[[0] * 3 for _ in range(2)] for _ in range(n + 1)]
        dp[0][0][0] = 1
        for index in range(1, n + 1):
            # 如果是A
            for k in range(3):
                dp[index][1][0] = (dp[index][1][0] + dp[index - 1][0][k]) % mod_value

            # 如果是L
            for j in range(2):
                for k in range(1, 3):
                    dp[index][j][k] = (dp[index][j][k] + dp[index - 1][j][k - 1]) % mod_value

            # 如果是P
            for j in range(2):
                for k in range(3):
                    dp[index][j][0] = (dp[index][j][0] + dp[index - 1][j][k]) % mod_value

        ans = 0
        for j in range(2):
            for k in range(3):
                ans = (ans + dp[n][j][k]) % mod_value
        return ans