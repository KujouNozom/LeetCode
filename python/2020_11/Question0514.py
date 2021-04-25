# 514.自由之路
# [困难]
# 电子游戏“辐射4”中，任务“通向自由”要求玩家到达名为“Freedom Trail Ring”的金属表盘，并使用表盘拼写特定关键词才能开门。
#
# 给定一个字符串 ring，表示刻在外环上的编码；给定另一个字符串 key，表示需要拼写的关键词。您需要算出能够拼写关键词中所有字符的最少步数。
#
# 最初，ring 的第一个字符与12:00方向对齐。您需要顺时针或逆时针旋转 ring 以使 key 的一个字符在 12:00 方向对齐，然后按下中心按钮，以此逐个拼写完 key 中的所有字符。
#
# 旋转 ring 拼出 key 字符 key[i] 的阶段中：
#
# 您可以将 ring 顺时针或逆时针旋转一个位置，计为1步。旋转的最终目的是将字符串 ring 的一个字符与 12:00 方向对齐，并且这个字符必须等于字符 key[i] 。
# 如果字符 key[i] 已经对齐到12:00方向，您需要按下中心按钮进行拼写，这也将算作 1 步。按完之后，您可以开始拼写 key 的下一个字符（下一阶段）, 直至完成所有拼写。
# 示例
#
#
# 输入: ring = "godding", key = "gd"
#
# 输出: 4
#
# 解释:
#
# 对于 key 的第一个字符 'g'，已经在正确的位置, 我们只需要1步来拼写这个字符。
# 对于 key 的第二个字符 'd'，我们需要逆时针旋转 ring "godding" 2步使它变成 "ddinggo"。
# 当然, 我们还需要1步进行拼写。
# 因此最终的输出是 4。
# 提示
# ring 和 key 的字符串长度取值范围均为 1 至 100；
# 两个字符串中都只有小写字符，并且均可能存在重复字符；
# 字符串 key 一定可以由字符串 ring 旋转拼出。

# 题解
# 动态规划
# dp[i][j]：表示拼写 key 中的 i，且使用 ring 中的第 j 个字符所需要的最小步数。
# 我们可以知道只有 i 和 j 指向的字母相同的时候这个值才有意义，因为是使用 j 来拼写 i。所以我们只需要计算 key[i] 字母所在 ring 的位置 j 的数值
# 因为只有拼写完成了 i 才能拼写 i + 1，因此，状态转移方程是
# dp[i][k] =  min(dp[i-1][j] + ditance(j, k))，这里的 j 是key中 key 数组中 i-1 位置字母所有索引位置集合，因为我们必须按照 key 中的字母顺序拼写
# 至于 ditance 函数，是用来计算由 j 转换到 k 的需要的步数
# 我们分两种情况讨论从 j 到 k 的步数，不算按钮那一步
# j 的下标大于 k：逆时针步数是 j-k。 顺时针的步数是, j 先到0，步数是 n-j；然后是 0 到 k，步数是 k.总步数 n - j + k
# j 的小标小于 k：顺时针步数是 k-j。逆时针步数是，j 先到 0，步数是 j；然后是 0 到 k，步数是 n - k.总步数是 n - k + j
# 两个和在一起，可以总结为 abs(j - k) 和 n - abs(j - k)。最后再加上按按钮的那一步

class Solution:

    def findRotateSteps(self, ring: str, key: str) -> int:
        global length_ring

        length_ring = len(ring)
        length_key = len(key)

        # 先统计每个字符出现的小标数组
        ring_char_indexes = {}
        for index, temp in enumerate(ring):
            temp_index = ring_char_indexes.get(temp, [])
            temp_index.append(index)
            ring_char_indexes[temp] = temp_index

        # 最大步数是 100*100,所以赋初始值是100*100
        max_step = 100 * 100
        dp = []
        for i in range(length_key):
            dp.append([max_step] * length_ring)

        for i in ring_char_indexes[key[0]]:
            dp[0][i] = Solution.get_distance(i, 0)

        for i in range(1, length_key):
            for k in ring_char_indexes[key[i]]:
                min_value = 100 * 100
                for j in ring_char_indexes[key[i - 1]]:
                    min_value = min(min_value, dp[i - 1][j] + Solution.get_distance(j, k))
                dp[i][k] = min_value
        return min(dp[length_key - 1])

    def get_distance(j, k):
        """
        我们分两种情况讨论从 j 到 k 的步数，不算按钮那一步
        1. j 的下标大于 k
        逆时针步数是 j-k
        顺时针的步数是, j 先到0，步数是 n-j;然后是 0 到 k，步数是 k.总步数 n - j + k

        2.j 的小标小于 k
        顺时针步数是 k-j
        逆时针步数是，j 先到 0，步数是 j;然后是 0 到 k，步数是 n - k.总步数是 n - k + j

        两个和在一起，可以总结为 abs(j - k) 和 n - abs(j - k)

        """
        global length_ring
        return min(abs(j - k), length_ring - abs(j - k)) + 1


print(Solution().findRotateSteps("godding", "gd"))
