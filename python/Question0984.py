# 984.不含 AAA 或 BBB 的字符串
# [中等]
# 给定两个整数 A 和 B，返回任意字符串 S，要求满足：
# S 的长度为 A + B，且正好包含 A 个 'a' 字母与 B 个 'b' 字母；
# 子串 'aaa' 没有出现在 S 中；
# 子串 'bbb' 没有出现在 S 中。
# 示例
# 示例 1
# 输入：A = 1, B = 2
# 输出："abb"
# 解释："abb", "bab" 和 "bba" 都是正确答案。
# 示例 2
# 输入：A = 4, B = 1
# 输出："aabaa"
# 提示
# 0 <= A <= 100
# 0 <= B <= 100
# 对于给定的 A 和 B，保证存在满足要求的 S。
# 题解
# 贪心算法
# 我们首先确定 a b 那个字母出现的次数多，设置为 x，少的设置为 y。同时计算 x y 的个数 count_x，count_y
# 当两个字母剩余个数不是0，同时 count_x > count_y，我们添加两个 x 一个y 来减小 x y 之间的剩余个数差
# 当循环终止的时候，说明 x y 一种一个耗尽，或者 count_x 不再大于count_y，并且两个的差不是1 就是 0
# 因为差值不是 1 就是 0，因此我们后面可以使用 x y 这种形式,，直到 x y 一种一个耗尽（观察上面的循环，此时结尾字符肯定是y。并且 0 1 的差别就在最终结果字符串以什么结尾，不需要考虑）
# 最后把剩余的字符添加到末尾，这里不需要判断是否满足，因为题目保证了结果

class Solution:
    def strWithout3a3b(self, A: int, B: int) -> str:
        x, y = ('a', 'b') if A > B else ('b', 'a')
        count_x, count_y = max(A, B), min(A, B)
        ans = []
        while count_x > count_y and count_x and count_y:
            count = 2 if count_x >= 2 else 1
            ans.append(x * count)
            count_x -= count

            ans.append(y)
            count_y -= 1

        for _ in range(min(count_x, count_y)):
            ans.append(x + y)

        if count_y > count_x:
            ans.append(y * count_y)
        if count_x > count_y:
            ans.append(x * count_x)

        return ''.join(ans)


print(Solution().strWithout3a3b(4, 1))
