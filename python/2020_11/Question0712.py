# 712.两个字符串的最小ASCII删除和
# [中等]
# 给定两个字符串s1, s2，找到使两个字符串相等所需删除字符的ASCII值的最小和。
#
# 示例
# 示例 1
# 输入: s1 = "sea", s2 = "eat"
# 输出: 231
# 解释: 在 "sea" 中删除 "s" 并将 "s" 的值(115)加入总和。
# 在 "eat" 中删除 "t" 并将 116 加入总和。
# 结束时，两个字符串相等，115 + 116 = 231 就是符合条件的最小和。
# 示例 2
# 输入: s1 = "delete", s2 = "leet"
# 输出: 403
# 解释: 在 "delete" 中删除 "dee" 字符串变成 "let"，
# 将 100[d]+101[e]+101[e] 加入总和。在 "leet" 中删除 "e" 将 101[e] 加入总和。
# 结束时，两个字符串都等于 "let"，结果即为 100+101+101+101 = 403 。
# 如果改为将两个字符串转换为 "lee" 或 "eet"，我们会得到 433 或 417 的结果，比答案更大。
# 注意
# 0 < s1.length, s2.length <= 1000。
# 所有字符串中的字符ASCII值在[97, 122]之间。
# 题解
# 动态规划
# 字符串转换问题，我们可以使用动态规划
# dp[i][j]：表示 s1 中的前 i 个字母和 s2 中的前 j 个字转换成一样需要的删除字母的最小和
# 状态转移方程：
# 当 s1[i] 和 s2[j] 相同的时候，dp[i][j] = dp[i-1][j-1]
# s1[i] != s2[j] 的时候，dp[i][j]
# 初始值 dp[i][0] = sum[i] 前缀和，dp[0][j] = sum[j] 前缀和，因为是和另一个空串比较，因此所有字符都需要删除
# 最终结果 dp[i][j]

class Solution:
    def minimumDeleteSum(self, s1: str, s2: str) -> int:
        length1 = len(s1)
        length2 = len(s2)

        dp = [[0] * (length2 + 1) for _ in range(length1 + 1)]

        temp_sum = 0
        for index in range(1, length1 + 1):
            temp_sum += ord(s1[index - 1])
            dp[index][0] = temp_sum

        temp_sum = 0
        for index in range(1, length2 + 1):
            temp_sum += ord(s2[index - 1])
            dp[0][index] = temp_sum

        for i in range(length1):
            for j in range(length2):
                if s1[i] == s2[j]:
                    dp[i + 1][j + 1] = dp[i][j]
                else:
                    dp[i + 1][j + 1] = min(dp[i][j + 1] + ord(s1[i]), dp[i + 1][j] + ord(s2[j]))

        return dp[length1][length2]
