# 1702. 修改后的最大二进制字符串 [规律]
import collections


class Solution:
    def maximumBinaryString(self, binary: str) -> str:
        # 首先数字最大的话，左侧连续的1是不需要移动的，因此首先找到左侧连续的1把这部分截取掉，处理剩下的部分
        # 00 -> 10，可以看出，我们需要将0换到前面，这样连续的0可以转换为11...10
        # 10 -> 01 表示，1可以和0 换位置，并且只能向后换，我们可以先把 1 全部换到后面，前面全是0
        # 因此我们只需要统计0，1的个数，最后最大值肯定是 1{count0-1} 0 1{count1}

        tail_index = 0
        length = len(binary)
        while tail_index < length and binary[tail_index] == '1':
            tail_index += 1
        if tail_index == length:
            return binary
        tail = binary[:tail_index]
        binary = binary[tail_index:]

        num_counts = dict(collections.Counter(binary))
        ans = []
        if num_counts.get('0', 0):
            ans.extend(['1'] * (num_counts.get('0') - 1))
            ans.append('0')
        if num_counts.get('1', 0):
            ans.extend(['1'] * num_counts.get('1', 0))

        return tail + ''.join(ans)