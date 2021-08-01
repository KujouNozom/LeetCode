# 981. 基于时间的键值存储 [Hash，二分查找]
def bin_search(data: list, target: int) -> int:
    left, right = 0, len(data) - 1
    ans = -1

    while left <= right:
        mid = (left + right) // 2
        if data[mid] <= target:
            ans = mid
            left = mid + 1
        else:
            right = mid - 1

    return ans


class TimeMap:

    def __init__(self):
        self.values = {}

    def set(self, key: str, value: str, timestamp: int) -> None:
        value_time = self.values.get(key, ([], []))
        self.values[key] = value_time
        self.values[key][0].append(timestamp)
        self.values[key][1].append(value)

    def get(self, key: str, timestamp: int) -> str:
        if self.values.get(key, None):
            index = bin_search(self.values[key][0], timestamp)
            if index != -1:
                return self.values[key][1][index]
        return ''
