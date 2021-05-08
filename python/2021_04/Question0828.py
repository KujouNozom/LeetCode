# 828. 统计子串中的唯一字符 [双指针]
import collections


class Solution:
    def uniqueLetterString(self, s: str) -> int:
        num_indexes = collections.defaultdict(list)
        for index, value in enumerate(s):
            num_indexes[value].append(index)

        ans = 0
        length = len(s)
        for value_indexes in num_indexes.values():
            value_indexes = [-1] + value_indexes + [length]
            for index in range(1, len(value_indexes) - 1):
                ans += (value_indexes[index] - value_indexes[index - 1]) * (
                        value_indexes[index + 1] - value_indexes[index])

        return ans
