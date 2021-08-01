# 239. 滑动窗口最大值 [单调队列]
import collections
from typing import List


def push_value(queue: collections.deque, value, index):
    while queue and queue[-1][0] < value:
        queue.pop()
    queue.append((value, index))


def get_value(queue: collections.deque, index) -> int:
    while queue[0][1] < index:
        queue.popleft()
    return queue[0][0]


class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        queue = collections.deque()
        length = len(nums)
        for index in range(k):
            push_value(queue, nums[index], index)
        ans = [get_value(queue, 0)]
        for index in range(k, length):
            push_value(queue, nums[index], index)
            ans.append(get_value(queue, index - k + 1))
        return ans
