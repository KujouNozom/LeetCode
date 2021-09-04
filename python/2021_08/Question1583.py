# 1583. 统计不开心的朋友 [Hash，模拟]
from typing import List


class Solution:
    def unhappyFriends(self, n: int, preferences: List[List[int]], pairs: List[List[int]]) -> int:
        pairs_dict = {}
        ans_list = set()

        for pair in pairs:
            pairs_dict[pair[0]], pairs_dict[pair[1]] = pair[1], pair[0]

        for index in range(n):
            if index in ans_list:
                continue
            x, y = index, pairs_dict[index]
            u_list = preferences[x][:preferences[x].index(y)]
            for u in u_list:
                v = pairs_dict[u]
                u_preference = preferences[u]
                if u_preference.index(x) < u_preference.index(v):
                    ans_list.add(x)
                    ans_list.add(u)

        return len(ans_list)