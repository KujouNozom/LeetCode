# 16.01交换数字
# [中等]
# 编写一个函数，不用临时变量，直接交换numbers = [a, b]中a与b的值。
# 示例
# 输入: numbers = [1,2]
# 输出: [2,1]
# 提示
# numbers.length == 2
# 题解
# 两种方式
# 1.使用加减法求和然后交换 a，b
# a + b，b = a + b，b
# a + b，(a + b) - b = a
# (a + b) - a，a = b , a
# 2.使用位运算
# a ^ b，b = a ^ b，b
# a ^ b，(a ^ b) ^ b = a ^ b，a ^ (b ^ b) = a ^ b，a ^ 0 = a ^ b，a
# (a ^ b) ^ a，a = (a ^ a) ^ b , a = 0 ^ b，a = b，a

from typing import List


class Solution:
    # 方法1：使用+ -
    # def swapNumbers(self, numbers: List[int]) -> List[int]:
    #     numbers[0] = numbers[0] + numbers[1]
    #     numbers[1] = numbers[0] - numbers[1]
    #     numbers[0] = numbers[0] - numbers[1]
    #     return numbers

    # 方法2：使用位运算
    def swapNumbers(self, numbers: List[int]) -> List[int]:
        numbers[0] = numbers[0] ^ numbers[1]
        numbers[1] = numbers[0] ^ numbers[1]
        numbers[0] = numbers[0] ^ numbers[1]
        return numbers
