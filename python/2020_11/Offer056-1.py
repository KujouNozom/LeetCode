# 剑指 Offer 56 - I. 数组中数字出现的次数
# 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
# 示例
# 示例 1
# 输入：nums = [4,1,4,6]
# 输出：[1,6] 或 [6,1]
# 示例 2
# 输入：nums = [1,2,10,4,1,4,3,3]
# 输出：[2,10] 或 [10,2]
# 限制
# 2 <= nums.length <= 10000
# 题解
# 先对所有数据进行异或操作，因为相同的数字异或为0，又因为 a ^ (b ^ c) = (a ^ b) ^ c，所以得到
# a ^ a ^ b ^ b ^..... ^ x ^ y = (a ^ a) ^ (b ^ b) ..... ^ x ^ y = 0 ^ 0 .... ^ x ^ y
# 我们最终得到结果 c ,是单独出现的 x 和 y 的异或值，我们找到最低位的 1 ，这一位就是 x y 最小的不同位 index
# 我们将数字分成两部分，一部分 index 位置为0，一部分 index 位置为1，x y 分别属于两个集合
# 我们将两个集合分别进行异或，类上面的操作，结果就是 x y ，因为这次x y 数据两个结果集了， 0^0^...x = x

from typing import List


class Solution:
    def singleNumbers(self, nums: List[int]) -> List[int]:
        c = 0
        for num in nums:
            c ^= num
        c_string = str(bin(c))
        index = len(c_string) - 1 - c_string.rfind('1')

        t = 1
        for i in range(index):
            t <<= 1
        a, b = 0, 0
        for num in nums:
            if num & t:
                a ^= num
            else:
                b ^= num

        return [a, b]
