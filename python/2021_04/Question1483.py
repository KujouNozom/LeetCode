# 1483. 树节点的第 K 个祖先 [动态规划，倍增]
class TreeAncestor:
    def __init__(self, n: int, parent: List[int]):
        length = len(bin(n)) - 2
        dp = [[-1] * length for _ in range(n)]
        for index in range(n):
            dp[index][0] = parent[index]

        for j in range(1, length):
            for i in range(n):
                temp_parent_value = dp[i][j - 1]
                if temp_parent_value != -1:
                    dp[i][j] = dp[dp[i][j - 1]][j - 1]

        self.dp = dp

    def getKthAncestor(self, node: int, k: int) -> int:
        bin_values = reversed(bin(k)[2:])
        for index, value in enumerate(bin_values):
            if node == -1:
                return -1
            if value != '0':
                node = self.dp[node][index]

        return node