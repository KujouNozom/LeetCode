# 1447.最简分数
# [中等]
# 给你一个整数 n ，请你返回所有 0 到 1 之间（不包括 0 和 1）满足分母小于等于  n 的 最简 分数 。分数可以以 任意 顺序返回。
# 示例
# 示例 1
# 输入：n = 2
# 输出：["1/2"]
# 解释："1/2" 是唯一一个分母小于等于 2 的最简分数。
# 示例 2
# 输入：n = 3
# 输出：["1/2","1/3","2/3"]
# 示例 3
# 输入：n = 4
# 输出：["1/2","1/3","1/4","2/3","3/4"]
# 解释："2/4" 不是最简分数，因为它可以化简为 "1/2" 。
# 示例 4
# 输入：n = 1
# 输出：[]
# 提示
# 1 <= n <= 100
# 题解
# 暴力
# 遍历分子和分母，外层是分母 i ，从 2 开始，因为 1 的话肯定大于等于1。内层是 [1, i)，
# 我们使用一个集合存储 j/i，当出现重复的时候说明之前已经添加的响应的最简形式（因为我们从小打到大遍历的），不重复则添加到结果

from typing import List


class Solution:
    def simplifiedFractions(self, n: int) -> List[str]:
        ans = []
        temp_set = set()
        for i in range(2, n + 1):
            for j in range(1, i):
                temp = j / i
                if temp not in temp_set:
                    temp_set.add(temp)
                    ans.append(f"{j}/{i}")
        return ans
