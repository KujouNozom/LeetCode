# 645. 错误的集合 [数组，hash]
class Solution:
    def findErrorNums(self, nums: List[int]) -> List[int]:
        num_counts = dict(collections.Counter(nums))

        ans = [0, 0]
        for index in range(1, len(nums) + 1):
            count = num_counts.get(index, 0)
            if count == 2:
                ans[0] = index
                continue
            if count == 0:
                ans[1] = index

        return ans
