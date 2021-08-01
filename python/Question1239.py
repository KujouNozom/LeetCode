# 1239. 串联字符串的最大长度 [位运算，回溯]
from typing import List


def get_bin(data: str) -> bin:
    nums = [0] * 26
    for w in data:
        key = ord(w) - ord('a')
        if nums[key] == 0:
            nums[key] = 1
        else:
            return None

    ans = 0
    for b in nums:
        ans = 2 * ans + b

    return ans


class Solution:
    def maxLength(self, arr: List[str]) -> int:
        def backtrack(current: int, index: int):
            nonlocal ans, length, bin_length_values
            if index == length:
                ans = max(ans, bin(current).count('1'))
                return

            if not bin_length_values[index] & current:
                backtrack(current | bin_length_values[index], index + 1)
            backtrack(current, index + 1)

        bin_length_values = [get_bin(data) for data in arr if get_bin(data)]
        length = len(bin_length_values)
        ans = 0

        backtrack(0, 0)
        return ans
