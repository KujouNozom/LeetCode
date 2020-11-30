# 718. 最长重复子数组
#
# 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
#
#
#
# 示例：
#
# 输入：
# A: [1,2,3,2,1]
# B: [3,2,1,4,7]
# 输出：3
# 解释：
# 长度最长的公共子数组是 [3, 2, 1] 。
#
#
#
# 提示：
#
#     1 <= len(A), len(B) <= 1000
#     0 <= A[i], B[i] < 100
# dp[i][j] 表示A以i结尾和B以j结尾的最长相同子串的长度。dp[i][j] = dp[i - 1][j - 1] + 1 if A[i - 1] == B[j - 1] else 0

from typing import List


class Solution:
    def findLength(self, A: List[int], B: List[int]) -> int:
        m = len(A)
        n = len(B)
        ans = 0

        dp = [[0] * (m + 1) for _ in range(m + 1)]
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                dp[i][j] = dp[i - 1][j - 1] + 1 if A[i - 1] == B[j - 1] else 0
                ans = max(ans, dp[i][j])

        return ans
