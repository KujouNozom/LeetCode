# 我们是用优先级队列保存最小的 k 个数字
# 这里我使用 Python3 我们使用堆相关的函数，先转换为堆，然后通过函数得到最小的 k 个数字
#
# 剑指 Offer 040. 最小的k个数
# 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
# 示例
# 示例 1
# 输入：arr = [3,2,1], k = 2
# 输出：[1,2] 或者 [2,1]
# 示例 2：
# 输入：arr = [0,1,2,1], k = 1
# 输出：[0]
# 限制
# 0 <= k <= arr.length <= 10000
# 0 <= arr[i] <= 10000

import heapq
from typing import List


class Solution:
    def getLeastNumbers(self, arr: List[int], k: int) -> List[int]:
        heapq.heapify(arr)
        return heapq.nsmallest(k, arr)
