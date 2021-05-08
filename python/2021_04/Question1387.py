# 1387. 将整数按权重排序 [数组]
weights = {1: 0}


def get_weight(k) -> int:
    if k not in weights:
        if k != 1:
            if k % 2 == 0:
                weights[k] = get_weight(k // 2) + 1
            if k % 2 == 1:
                weights[k] = get_weight(k * 3 + 1) + 1
    return weights[k]


class Solution:
    def getKth(self, lo: int, hi: int, k: int) -> int:
        values = [x for x in range(lo, hi + 1)]
        values.sort(key=lambda x: (get_weight(x), x))
        return values[k - 1]
