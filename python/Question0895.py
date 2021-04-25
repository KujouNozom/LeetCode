# 895. 最大频率栈 [栈，hash]
import collections


class FreqStack:
    def __init__(self):
        self.freq = dict()
        self.max_freq = 0
        self.freq_indexes = collections.defaultdict(list)

    def push(self, val: int) -> None:
        new_freq = self.freq.get(val, 0) + 1

        self.freq[val] = new_freq
        self.freq_indexes[new_freq].append(val)
        self.max_freq = max(self.max_freq, new_freq)

    def pop(self) -> int:
        pop_val = self.freq_indexes[self.max_freq].pop()

        new_freq = self.freq.get(pop_val) - 1
        self.freq[pop_val] = new_freq
        self.max_freq = self.max_freq if self.freq_indexes[self.max_freq] else new_freq
        return pop_val
