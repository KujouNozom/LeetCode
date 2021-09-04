# 576. 出界的路径数 [动态规划]
class Solution:
    def findPaths(self, m: int, n: int, maxMove: int, startRow: int, startColumn: int) -> int:
        fwi, fwj = [0, -1, 0, 1], [1, 0, -1, 0]
        mod_value = 10 ** 9 + 7

        dp = [[[0] * (maxMove + 1) for _ in range(n)] for _ in range(m)]
        dp[startRow][startColumn][0] = 1

        ans = 0
        for k in range(maxMove):
            for i in range(m):
                for j in range(n):
                    if dp[i][j][k] > 0:
                        for index in range(4):
                            new_i, new_j = i + fwi[index], j + fwj[index]
                            if 0 <= new_i < m and 0 <= new_j < n:
                                dp[new_i][new_j][k + 1] = (dp[new_i][new_j][k + 1] + dp[i][j][k]) % mod_value
                            else:
                                ans = (ans + dp[i][j][k]) % mod_value

        return ans
