# 171. Excel 表列序号 [进制]
class Solution:
    def titleToNumber(self, columnTitle: str) -> int:
        ans = 0
        for column in columnTitle:
            ans = ans * 26 + (ord(column) - ord('A') + 1)
        return ans
