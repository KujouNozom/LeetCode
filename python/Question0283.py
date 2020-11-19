# 283.移动零
# 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
# 示例
# 输入: [0,1,0,3,12]
# 输出: [1,3,12,0,0]
# 说明
# 必须在原数组上操作，不能拷贝额外的数组。
# 尽量减少操作次数。
# 题解
# 双指针，使用一个指针 index_zero 指向当前遍历的最前面的 0，另一个指针 index 指向这个 0 后面的第一个不是 0 的元素
# 这样，两个指针中间的元素就全是 0，我们交换 index 和 index_zero，然后移动两个指针
# 接下来移动第二个指针，如果不是0，继续交换，保持两个指针中间全是0

from typing import List


class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        index_zero = 0
        length = len(nums)
        while index_zero < length and nums[index_zero]:
            index_zero += 1
        index = index_zero + 1

        while index < length:
            if nums[index]:
                nums[index_zero], nums[index] = nums[index], nums[index_zero]
                index_zero += 1
            index += 1
