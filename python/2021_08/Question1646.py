# 1646. 获取生成数组中的最大值 [模拟，动态规划]
class Solution:
    def getMaximumGenerated(self, n: int) -> int:
        if n == 0:
            return 0
        if n == 1:
            return 1

        dp = [0] * (n + 1)
        dp[1] = 1
        ans = 0
        for index in range(2, n + 1):
            half = index // 2
            value = dp[half]
            if index % 2 == 1:
                value += dp[half + 1]
            dp[index] = value
            ans = max(value, ans)
        return ans
