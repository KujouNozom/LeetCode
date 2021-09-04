# 551. 学生出勤记录 I [字符串]
class Solution:
    def checkRecord(self, s: str) -> bool:
        a_count = False
        l_count = 0
        for word in s:
            if word == 'A':
                l_count = 0
                if a_count:
                    return False
                else:
                    a_count = True
            elif word == 'L':
                if l_count == 2:
                    return False
                else:
                    l_count += 1
            else:
                l_count = 0
        return True
