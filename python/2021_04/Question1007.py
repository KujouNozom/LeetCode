# 1007. 行相等的最少多米诺旋转 [贪心算法]
from typing import List


class Solution:
    def minDominoRotations(self, A: List[int], B: List[int]) -> int:
        def get_count(num):
            count_a, count_b = 0, 0
            for index in range(length):
                if A[index] == num or B[index] == num:
                    if A[index] == num:
                        count_a += 1
                    if B[index] == num:
                        count_b += 1
                else:
                    return -1

            return max(count_a, count_b)

        length = len(A)
        ans = length - max(get_count(A[0]), get_count(B[0]))
        return ans if ans <= length else -1
