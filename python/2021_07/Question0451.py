# 451. 根据字符出现频率排序 [Hash,排序]
import collections


class Solution:
    def frequencySort(self, s: str) -> str:
        counts = collections.Counter(s)
        sorted_list = sorted(counts.items(), key=lambda x: x[1], reverse=True)
        ans = []
        for sorted_value in sorted_list:
            value, count = sorted_value[0], sorted_value[1]
            ans.extend([value] * count)
        return ''.join(ans)
