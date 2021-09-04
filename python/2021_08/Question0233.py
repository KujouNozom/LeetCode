# 233. 数字 1 的个数 [动态规划，数学]
class Solution:
    def countDigitOne(self, n: int) -> int:
        length = len(str(n))
        ans = 0
        for index in range(0, length):
            mod_value, mod_value_head = 10 ** index, 10 ** (index + 1)
            head, tail = n // mod_value_head, n % mod_value_head

            ans += head * mod_value + (
                0 if tail < mod_value else (
                    tail - mod_value + 1 if tail < mod_value * 2 else mod_value))

        return ans


print(Solution().countDigitOne(0))
