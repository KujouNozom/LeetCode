# 1743. 从相邻元素对还原数组

class Solution:
    def restoreArray(self, adjacentPairs: List[List[int]]) -> List[int]:
        word_indexes = collections.defaultdict(list)
        for adjacent_pair in adjacentPairs:
            word_indexes[adjacent_pair[0]].append(adjacent_pair[1])
            word_indexes[adjacent_pair[1]].append(adjacent_pair[0])

        head = None
        for key, value in word_indexes.items():
            if len(value) == 1:
                head = key
                break
        ans = [head]

        length = len(word_indexes)

        while len(ans) < length:
            adjacent = word_indexes[ans[-1]]
            if (len(adjacent) == 2 and adjacent[1] == ans[-2]) or len(adjacent) == 1:
                ans.append(adjacent[0])
            else:
                ans.append(adjacent[1])

        return ans