# 541. 反转字符串 II [字符串]
class Solution:
    def reverseStr(self, s: str, k: int) -> str:
        list_s = list(s)
        length = len(list_s)
        start = 0
        flag = False
        ans = []
        while start < length:
            values = list_s[start:start + k]
            if flag:
                ans.extend(values)
            else:
                ans.extend(reversed(values))
            flag, start = not flag, start + k

        return ''.join(ans)


print(Solution().reverseStr('abcd', 2))
