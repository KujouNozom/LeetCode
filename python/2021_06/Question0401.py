# 401. 二进制手表 [回溯，递归]
from typing import List


def function(current: List[str], current_index: int, count: int, ans: List[str]):
    if count == 0:
        value = ''.join(current)
        hour = int(value[:4], 2)
        if 0 <= hour <= 11:
            minutes = int(value[4:], 2)
            if 0 <= minutes <= 59:
                ans.append('%d:%02d' % (hour, minutes))
    else:
        for index in range(current_index, 10):
            current[index] = '1'
            function(current, index + 1, count - 1, ans)
            current[index] = '0'


class Solution:
    def readBinaryWatch(self, turnedOn: int) -> List[str]:
        ans = []
        current = ['0'] * 10
        function(current, 0, turnedOn, ans)
        return ans
