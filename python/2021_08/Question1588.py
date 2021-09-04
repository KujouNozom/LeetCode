# 1588. 所有奇数长度子数组的和 [前缀和]
from typing import List


class Solution:
    def sumOddLengthSubarrays(self, arr: List[int]) -> int:
        pre_sums = [0]
        for num in arr:
            pre_sums.append(pre_sums[-1] + num)

        length = len(arr)
        ans = 0
        for len_ran in range(1, length + 1, 2):
            for index in range(length + 1 - len_ran):
                temp = pre_sums[index + len_ran] - pre_sums[index]
                ans += temp

        return ans


print(Solution().sumOddLengthSubarrays(arr=[10, 11, 12]))
