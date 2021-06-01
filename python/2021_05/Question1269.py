# 1269. 停在原地的方案数 [动态规划]
class Solution:
    def numWays(self, steps: int, arrLen: int) -> int:
        model = 10 ** 9 + 7
        length = min(steps // 2 + 1, arrLen - 1) + 1

        dp = [0] * length
        dp[0] = 1
        for index_step in range(steps):
            temp = [0] * length
            temp[0] = (dp[0] + dp[1]) % model
            temp[-1] = dp[-1] + dp[-2] % model
            for index_arr in range(1, length - 1):
                temp[index_arr] = (dp[index_arr - 1] + dp[index_arr] + dp[index_arr + 1]) % model
            dp = temp

        return dp[0]