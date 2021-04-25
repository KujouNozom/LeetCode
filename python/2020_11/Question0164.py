from typing import List


class Solution:
    def maximumGap(self, nums: List[int]) -> int:
        length = len(nums)
        if length < 2:
            return 0

        max_num = max(nums)
        min_num = min(nums)
        bucket_size = max(1, (max_num - min_num) // (length - 1))
        bucket_num = (max_num - min_num) // bucket_size + 1

        bucket_values = [[None, None] for _ in range(bucket_num)]
        for num in nums:
            bucket_index = (num - min_num) // bucket_size
            min_value = bucket_values[bucket_index][0]
            max_value = bucket_values[bucket_index][1]

            bucket_values[bucket_index][0] = min(min_value, num) if min_value else num
            bucket_values[bucket_index][1] = max(max_value, num) if max_value else num

        ans = 0
        pre = bucket_values[0][0]
        for index in range(bucket_num):
            temp_value = bucket_values[index][0]
            if temp_value:
                ans = max(ans, temp_value - pre)
            if bucket_values[index][1]:
                pre = bucket_values[index][1]

        return ans


Solution().maximumGap([1, 3, 100])
