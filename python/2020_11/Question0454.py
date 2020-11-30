# 454. 四数相加 II
#
# 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
# 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
#
# 例如:
# 输入:
# A = [ 1, 2]
# B = [-2,-1]
# C = [-1, 2]
# D = [ 0, 2]
# 输出:
# 2
#
# 解释:
# 两个元组如下:
# 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
# 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0

from typing import List


class Solution:
    def fourSumCount(self, A: List[int], B: List[int], C: List[int], D: List[int]) -> int:
        sum_1, sum_2 = Solution.get_sum(None, A, B), Solution.get_sum(None, C, D)
        ans = 0

        for (key, sum_count_1) in sum_1.items():
            sum_count_2 = sum_2.get(0 - key, 0)
            ans += sum_count_2 * sum_count_1

        return ans

    def get_sum(self, A: List[int], B: List[int]) -> dict:
        sum = {}
        for a in A:
            for b in B:
                sum[a + b] = sum.get(a + b, 0) + 1

        return sum
