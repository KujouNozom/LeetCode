# 132. 分割回文串 II [动态规划]
def get_palindrome(length, s):
    palindrome = [[True] * length for _ in range(length)]
    for i in range(length - 1, -1, -1):
        for j in range(i + 1, length):
            palindrome[i][j] = (s[i] == s[j]) and palindrome[i + 1][j - 1]
    return palindrome


class Solution:
    def minCut(self, s: str) -> int:
        length = len(s)
        palindrome = get_palindrome(length, s)

        dp = [length] * length
        for i in range(length):
            if palindrome[0][i]:
                dp[i] = 0
            else:
                for j in range(i):
                    if palindrome[j + 1][i]:
                        dp[i] = min(dp[i], dp[j] + 1)

        return dp[length - 1]
