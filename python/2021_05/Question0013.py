# 13. 罗马数字转整数 [字符串]
values = {"M": 1000, "D": 500, "C": 100, "L": 50, "X": 10, "V": 5, "I": 1}


class Solution:
    def romanToInt(self, s: str) -> int:
        ans = 0
        length = len(s)

        for index, value in enumerate(s):
            current_value = values[value]
            next_value = values[s[index + 1]] if index + 1 < length else 0
            if current_value < next_value:
                ans -= current_value
            else:
                ans += current_value
        return ans
