# 480. 滑动窗口中位数
from bisect import bisect
from typing import List


def get_mid(nums: list) -> int:
    length = len(nums)
    return nums[length // 2] if length % 2 == 1 else (nums[length // 2] + nums[(length - 1) // 2]) / 2


class Solution:
    def medianSlidingWindow(self, nums: List[int], k: int) -> List[float]:
        ans = []
        length = len(nums)
        window = nums[:k]
        window.sort()
        ans.append(get_mid(window))

        for index in range(k, length):
            insert_value = nums[index]
            remove_value = nums[index - k]
            window.remove(remove_value)
            window.insert(bisect.bisect_left(window, insert_value), insert_value)
            ans.append(get_mid(window))
        return ans
