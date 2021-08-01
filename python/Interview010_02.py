# 面试题 10.02. 变位词组 [Hash,排序]
import collections
from typing import List


class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        str_index = collections.defaultdict(list)
        [values for values in strs if not str_index[''.join(sorted(values))].append(values)]
        return list(str_index.values())
