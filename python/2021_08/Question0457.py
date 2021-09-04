# 457. 环形数组是否存在循环 [快慢指针]
from typing import List


class Solution:
    def circularArrayLoop(self, nums: List[int]) -> bool:
        def move(current: int) -> int:
            return (current + nums[current]) % length

        length = len(nums)
        visited = [False] * length
        for index, num in enumerate(nums):
            if not visited[index]:
                slow, fast = index, move(index)
                while not visited[slow] and nums[slow] * nums[move(slow)] > 0 and nums[fast] * nums[move(fast)] \
                        and nums[fast] * nums[move(move(fast))] > 0:
                    if slow == move(slow):
                        break
                    if slow == fast:
                        return True
                    slow, fast = move(slow), move(move(fast))

                step = index
                while not visited[slow] and nums[step] * nums[move(step)] > 0:
                    step, visited[step] = move(step), True
        return False
