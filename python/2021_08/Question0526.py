# 526. 优美的排列 [回溯]
class Solution:
    def countArrangement(self, n: int) -> int:
        def back_tracking(index: int):
            nonlocal ans
            if index == (n + 1):
                ans += 1
                return
            valid_list = [i for i in range(1, (n + 1)) if not used[i] and (index % i == 0 or i % index == 0)]
            for value in valid_list:
                used[value] = True
                back_tracking(index + 1)
                used[value] = False

        used = [False] * (n + 1)
        ans = 0
        back_tracking(1)
        return ans
