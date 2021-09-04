# 881. 救生艇 [贪心，双指针]
from typing import List


class Solution:
    def numRescueBoats(self, people: List[int], limit: int) -> int:
        people.sort()
        length = len(people)
        left, right = 0, length - 1
        ans = 0
        while left <= right:
            if left == right or people[left] + people[right] <= limit:
                left = left + 1
            right -= 1
            ans += 1
        return ans
