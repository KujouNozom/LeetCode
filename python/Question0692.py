# 692.前K个高频单词 [排序]
import collections
from functools import cmp_to_key
from typing import List


def sorted_word(datas1: tuple, datas2: tuple):
    if datas1[1] > datas2[1]:
        return -1
    elif datas1[1] < datas2[1]:
        return 1
    else:
        return 1 if datas1[0] > datas2[0] else -1


class Solution:
    def topKFrequent(self, words: List[str], k: int) -> List[str]:
        words_count = collections.Counter(words)
        words_item: list = list(words_count.items())
        words_item.sort(key=cmp_to_key(sorted_word))
        return [data[0] for data in words_item[:k]]
