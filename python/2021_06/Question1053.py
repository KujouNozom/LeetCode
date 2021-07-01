# 1053. 交换一次的先前排列 [贪心算法]
from typing import List


def get_left_max_value(arr, change_value, index, length):
    max_value, max_index = arr[index], index
    for index_temp in range(index, length):
        value_temp = arr[index_temp]
        if change_value > value_temp > max_value:
            max_value, max_index = value_temp, index_temp
    return max_index


class Solution:
    def prevPermOpt1(self, arr: List[int]) -> List[int]:
        length = len(arr)

        for index in range(length - 1, 0, -1):
            if arr[index] < arr[index - 1]:
                change_value, change_index = arr[index - 1], index - 1
                max_index = get_left_max_value(arr, change_value, index, length)
                arr[change_index], arr[max_index] = arr[max_index], arr[change_index]
                break
        return arr
