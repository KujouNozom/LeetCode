# 1416. 恢复数组 [动态规划]
class Solution:
    def numberOfArrays(self, s: str, k: int) -> int:
        length = len(s)
        mod_value = 10 ** 9 + 7

        dp = [0] * (length + 1)
        # 第一个节点不需要做越界特殊处理
        dp[-1] = 1

        for index in range(length):
            for start_index in range(index, -1, -1):
                if index - start_index > 10:
                    break
                temp = s[start_index:index + 1]
                if temp.startswith('0'):
                    continue
                if int(temp) > k:
                    break
                dp[index] = (dp[index] + dp[start_index - 1]) % mod_value

        return dp[length - 1]
