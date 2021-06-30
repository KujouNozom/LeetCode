from collections import deque
from typing import List


def get_next(value: str, index: int) -> str:
    value_list = list(value)
    index_value = value_list[index]
    value_list[index] = '0' if index_value == '9' else str(int(index_value) + 1)
    return ''.join(value_list)


def get_pre(value: str, index: int) -> str:
    value_list = list(value)
    index_value = value_list[index]
    value_list[index] = '9' if index_value == '0' else str(int(index_value) - 1)
    return ''.join(value_list)


class Solution:
    def openLock(self, deadends: List[str], target: str) -> int:
        if target == '0000':
            return 0
        dead_set = set(deadends)
        if '0000' in dead_set:
            return -1

        queue = deque([("0000", 0)])
        be_cal = {'0000'}

        while queue:
            value, step = queue.popleft()
            for index in range(4):
                next_value = get_next(value, index)
                if next_value not in dead_set and next_value not in be_cal:
                    if next_value == target:
                        return step + 1
                    be_cal.add(next_value)
                    queue.append((next_value, step + 1))

                pre_value = get_pre(value, index)
                if pre_value not in dead_set and pre_value not in be_cal:
                    if pre_value == target:
                        return step + 1
                    be_cal.add(pre_value)
                    queue.append((pre_value, step + 1))
        return -1


print(Solution().openLock(deadends=["0201", "0101", "0102", "1212", "2002"], target="0202"))
