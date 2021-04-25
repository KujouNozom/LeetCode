# 88. 合并两个有序数组 [双指针]
from typing import List


class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        index1, index2, index_ans = m - 1, n - 1, m + n - 1

        while index1 >= 0 or index2 >= 0:
            if index2 < 0 or (index1 >= 0 and nums1[index1] >= nums2[index2]):
                nums1[index_ans] = nums1[index1]
                index1 -= 1
            else:
                nums1[index_ans] = nums2[index2]
                index2 -= 1
            index_ans -= 1