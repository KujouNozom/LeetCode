# 1137. 第 N 个泰波那契数 [动态规划]
import collections


class Solution:
    def tribonacci(self, n: int) -> int:
        values = [0, 1, 1]
        if n < 3:
            return values[n]

        temp = collections.deque()
        temp.extend([0, 1, 1, 2])
        for _ in range(3, n):
            ans = temp[-1] * 2 - temp[0]
            temp.popleft()
            temp.append(ans)

        return temp[-1]


print(Solution().tribonacci(25))
