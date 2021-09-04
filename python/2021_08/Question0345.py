# 345. 反转字符串中的元音字母 [双指针]
class Solution:
    def reverseVowels(self, s: str) -> str:
        vowels = set('aoeiuAOEIU')
        s_list = list(s)
        length = len(s)
        left, right = 0, length - 1
        while left < right:
            while left < length and s_list[left] not in vowels:
                left += 1
            while right >= 0 and s_list[right] not in vowels:
                right -= 1

            if left < right:
                s_list[left], s_list[right] = s_list[right], s_list[left]
                left += 1
                right -= 1

        return ''.join(s_list)
