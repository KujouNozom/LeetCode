# 1247. 交换字符使得字符串相同
#
# 有两个长度相同的字符串 s1 和 s2，且它们其中 只含有 字符 "x" 和 "y"，你需要通过「交换字符」的方式使这两个字符串相同。
# 每次「交换字符」的时候，你都可以在两个字符串中各选一个字符进行交换。
# 交换只能发生在两个不同的字符串之间，绝对不能发生在同一个字符串内部。也就是说，我们可以交换 s1[i] 和 s2[j]，但不能交换 s1[i] 和 s1[j]。
# 最后，请你返回使 s1 和 s2 相同的最小交换次数，如果没有方法能够使得这两个字符串相同，则返回 -1 。
#
# 示例 1：
# 输入：s1 = "xx", s2 = "yy"
# 输出：1
# 解释：
# 交换 s1[0] 和 s2[1]，得到 s1 = "yx"，s2 = "yx"。
#
# 示例 2：
# 输入：s1 = "xy", s2 = "yx"
# 输出：2
# 解释：
# 交换 s1[0] 和 s2[0]，得到 s1 = "yy"，s2 = "xx" 。
# 交换 s1[0] 和 s2[1]，得到 s1 = "xy"，s2 = "xy" 。
# 注意，你不能交换 s1[0] 和 s1[1] 使得 s1 变成 "yx"，因为我们只能交换属于两个不同字符串的字符。
#
# 示例 3：
# 输入：s1 = "xx", s2 = "xy"
# 输出：-1
#
# 示例 4：
# 输入：s1 = "xxyyxyxyxx", s2 = "xyyxyxxxyx"
# 输出：4
#
# 提示：
#     1 <= s1.length, s2.length <= 1000
#     s1, s2 只包含 'x' 或 'y'。
class Solution:
    def minimumSwap(self, s1: str, s2: str) -> int:
        length = len(s1)
        l1, l2 = list(s1), list(s2)

        ans = 0
        index = 0
        flag = False
        while index < length:
            value1, value2 = l1[index], l2[index]
            # 两个元素本来就相等
            if value1 == value2:
                index += 1
                continue

            # 找到s1中下一个和s1中当前元素相等的位置，并且这个位置对应的s2中元素不相等（需要替换）
            temp_index = index + 1
            while temp_index < length and (l1[temp_index] != value1 or l2[temp_index] == value1):
                temp_index += 1
            # 如果能找到，交换这个位置和s2当前元素
            if temp_index < length:
                flag = False
                l1[temp_index], l2[index] = l2[index], l1[temp_index]
                ans += 1
            # 找不到元素，这个时候交换s1和s2当前元素（因为两个元素不相等，找不到满足的x的位置，但是可能找到满足的y）
            # 注意需要记录一个标志位，如果x,y都找不到，那么返回-1
            else:
                if flag:
                    return -1
                l1[index], l2[index] = l2[index], l1[index]
                ans += 1
                flag = True
        return ans
