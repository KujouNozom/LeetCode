# 28. 实现 strStr() [双指针]
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        length_haystack, length_needle = len(haystack), len(needle)

        for index in range(0, length_haystack - length_needle + 1):
            if haystack[index:index + length_needle] == needle:
                return index
        return -1

# KMP
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        def build_next(needle: str) -> list:
            length = len(needle)
            next_array = [-1] * (length + 1)
            i, j = 0, -1
            while i < length:
                if j == -1 or needle[i] == needle[j]:
                    i, j = i + 1, j + 1
                    next_array[i] = j
                else:
                    j = next_array[j]
            return next_array

        next_array = build_next(needle)

        length_haystack = len(haystack)
        length_needle = len(needle)
        i, j = 0, 0
        while i < length_haystack and j < length_needle:
            if j == -1 or haystack[i] == needle[j]:
                i, j = i + 1, j + 1
            else:
                j = next_array[j]
        return i - length_needle if j == length_needle else -1