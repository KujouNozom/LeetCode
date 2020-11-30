# 767. 重构字符串
# [中等]
# 计算每个字符出现的次数，如果最多的超过 length+1 的一半，则无解
# 如果有等于一半（偶数）或者是+1的一半（奇数）的，那么这个数要放到所有偶数位（因为如果总数是奇数，开始和结尾都需要是这个数）其他数字放到奇数位
# 我们这样放数字：
# 使用两个指针，一个指向奇数，一个指向偶数
# 如果有等于一半（偶数）或者是+1的一半（奇数），不断放到偶数位置，偶数指针++
# 否则放到奇数位置奇数指针++，如果奇数位置用完，放到偶数位置
#
# 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
# 若可行，输出任意可行的结果。若不可行，返回空字符串。
# 示例 1:
# 输入: S = "aab"
# 输出: "aba"
#
# 示例 2:
# 输入: S = "aaab"
# 输出: ""
#
# 注意:
#
# S 只包含小写字母并且长度在[1, 500]区间内。

import collections


class Solution:
    def reorganizeString(self, S: str) -> str:
        counts = dict(collections.Counter(S))
        length = len(S)
        if max(counts.values()) > (length + 1) // 2:
            return ''

        index_1 = 0
        index_2 = 1

        max_count = length / 2

        ans = [''] * length
        for word, count in counts.items():
            if count <= max_count:
                while index_2 < length and count > 0:
                    ans[index_2] = word
                    count -= 1
                    index_2 += 2

                while index_1 < length and count > 0:
                    ans[index_1] = word
                    count -= 1
                    index_1 += 2
            else:
                while index_1 < length and count > 0:
                    ans[index_1] = word
                    count -= 1
                    index_1 += 2

        return ''.join(ans)
