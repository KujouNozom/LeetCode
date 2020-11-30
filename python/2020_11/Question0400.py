# 三步
# 1.计算这个数字是多少位
# 2.计算是这个位数数字的第几个
# 3.计算是这个数字的第几位
#
# 400. 第N个数字
# 第N个数字
# 在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 个数字。
# 示例
# 示例 1
# 输入：3
# 输出：3
# 示例 2
# 输入：11
# 输出：0
# 注意
# n 是正数且在32位整数范围内 ( n < 231)。
# 说明
# 第11个数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是0，它是10的一部分。

class Solution:
    def findNthDigit(self, n: int) -> int:
        nums_count = 1
        current_nums_count = 9
        while n > current_nums_count:
            n -= current_nums_count
            nums_count += 1
            current_nums_count = 9 * (10 ** (nums_count - 1)) * (nums_count)

        if nums_count == 1:
            return n

        target_num = (10 ** (nums_count - 1)) + ((n - 1) // nums_count)
        return int(str(target_num)[(n - 1) % nums_count])
