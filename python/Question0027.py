# 27. 移除元素 [双指针]
class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        ans_index = 0
        for index, num in enumerate(nums):
            if num != val:
                nums[ans_index] = num
                ans_index += 1
        return ans_index