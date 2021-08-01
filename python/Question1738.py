# 1736. 替换隐藏数字得到的最晚时间 [字符串]
class Solution:
    def maximumTime(self, time: str) -> str:
        functions = {
            0: lambda data: data[0] if data[0] != '?' else ('2' if data[1] == '?' or int(data[1]) < 4 else '1'),
            1: lambda data: data[1] if data[1] != '?' else ('3' if data[0] == '2' else '9'),
            2: lambda data: ':',
            3: lambda data: data[3] if data[3] != '?' else '5',
            4: lambda data: data[4] if data[4] != '?' else '9',
        }
        data = list(time)
        for index in range(5):
            data[index] = functions[index](data)
        return ''.join(data)
