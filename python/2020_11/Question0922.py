# 922.按奇偶排序数组 II
# [简单]
# 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
#
# 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
#
# 你可以返回任何满足上述条件的数组作为答案。
#
# 示例
# 输入：[4,2,5,7]
# 输出：[4,5,2,7]
# 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
# 提示
# 2 <= A.length <= 20000
# A.length % 2 == 0
# 0 <= A[i] <= 1000
# 题解
# 双指针
# 我们使用两个指针，一个指向奇数位置，一个指向偶数位置
# 我们移动其中指针直到找到不满足条件的位置，然后移动另一个指针直到不满足情况的位置，交换这两个指针位置的数字
# 之后再继续这要操作直到其中一个指针遍历结束（这里一个指针遍历结束，另一个指针不需要继续遍历，因为题目给的用例应该都是有解的）

from typing import List


class Solution:
    def sortArrayByParityII(self, A: List[int]) -> List[int]:
        length = len(A)
        index0 = 0
        index1 = 1
        while index0 < length and index1 < length:
            while index0 < length and A[index0] % 2 == 0:
                index0 += 2
            if index0 >= length:
                return A

            while index1 < length and A[index1] % 2 == 1:
                index1 += 2
            if index0 >= length:
                return A

            A[index0], A[index1] = A[index1], A[index0]
        return A
