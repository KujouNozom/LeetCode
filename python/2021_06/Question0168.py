# 168. Excel表列名称 [26进制]
class Solution:
    def convertToTitle(self, columnNumber: int) -> str:
        ans = []
        while columnNumber > 0:
            ans.append(chr((columnNumber - 1) % 26 + 65))
            columnNumber = (columnNumber - 1) // 26
        return ''.join(reversed(ans))
