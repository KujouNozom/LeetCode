# 738. 单调递增的数字
# 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
# （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
#
# 示例 1:
# 输入: N = 10
# 输出: 9
#
# 示例 2:
# 输入: N = 1234
# 输出: 1234
#
# 示例 3:
# 输入: N = 332
# 输出: 299
#
# 说明: N 是在 [0, 10^9] 范围内的一个整数。

class Solution:
    def monotoneIncreasingDigits(self, N: int):
        if not N:
            return 0

        data = [int(x) for x in str(N)]
        length = len(data)
        temp = [0] * length
        pre = 9
        for index in range(length - 1, -1, -1):
            if data[index] > pre:
                temp[index + 1:] = [9] * (length - index - 1)
                pre = data[index] - 1
            else:
                pre = data[index]
            temp[index] = pre

        ans = 0
        for num in temp:
            ans = ans * 10 + num
        return ans
