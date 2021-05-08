# 1324. 竖直打印单词 [数组]
from typing import List


class Solution:
    def printVertically(self, s: str) -> List[str]:
        src_worlds = s.split()
        len_worlds = [len(src_world) for src_world in src_worlds]
        max_count = max(len_worlds)
        length = len(src_worlds)

        ans = [''] * max_count
        for len_index in range(length):
            for index in range(max_count):
                if len_worlds[len_index] > index:
                    ans[index] += src_worlds[len_index][index]
                else:
                    ans[index] += ' '

        return [temp.rstrip() for temp in ans]
