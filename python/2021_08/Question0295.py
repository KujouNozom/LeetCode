# 295. 数据流的中位数 [大顶堆]
from heapq import heappop, heappush


class MedianFinder:
    def __init__(self):
        self.min_values = []
        self.max_values = []
        """
        initialize your data structure here.
        """

    def addNum(self, num: int) -> None:
        if not self.max_values or num >= self.max_values[0]:
            heappush(self.max_values, num)
            while len(self.min_values) + 1 < len(self.max_values):
                heappush(self.min_values, -heappop(self.max_values))
        else:
            heappush(self.min_values, -num)
            while len(self.min_values) > len(self.max_values):
                heappush(self.max_values, -heappop(self.min_values))

    def findMedian(self) -> float:
        if len(self.max_values) == len(self.min_values):
            return (self.max_values[0] - self.min_values[0]) / 2
        else:
            return self.max_values[0]
