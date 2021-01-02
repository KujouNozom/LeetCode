# 659. 分割数组为连续子序列
# 给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个子序列，其中每个子序列都由连续整数组成且长度至少为 3 。
# 如果可以完成上述分割，则返回 true ；否则，返回 false 。
#
# 示例 1：
# 输入: [1,2,3,3,4,5]
# 输出: True
# 解释:
# 你可以分割出这样两个连续子序列 :
# 1, 2, 3
# 3, 4, 5
#
# 示例 2：
# 输入: [1,2,3,3,4,4,5,5]
# 输出: True
# 解释:
# 你可以分割出这样两个连续子序列 :
# 1, 2, 3, 4, 5
# 3, 4, 5
#
# 示例 3：
# 输入: [1,2,3,4,4,5]
# 输出: False
#
# 提示：
# 输入的数组长度范围为 [1, 10000]

import heapq
from typing import List


class Solution:
    def isPossible(self, nums: List[int]) -> bool:
        indexs_count = {}
        for num in nums:
            if indexs_count.get(num - 1):
                pre_counts = indexs_count.get(num - 1, [])
                min_length = heapq.heappop(pre_counts)
                indexs_count[num - 1] = pre_counts

                cur_counts = indexs_count.get(num, [])
                heapq.heappush(cur_counts, min_length + 1)
                indexs_count[num] = cur_counts
            else:
                cur_counts = indexs_count.get(num, [])
                heapq.heappush(cur_counts, 1)
                indexs_count[num] = cur_counts
        return not any(counts and counts[0] < 3 for counts in indexs_count.values())