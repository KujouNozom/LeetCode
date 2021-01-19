# 721. 账户合并
#
# 给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其余元素是 emails 表示该账户的邮箱地址。
# 现在，我们想合并这些账户。如果两个账户都有一些共同的邮箱地址，则两个账户必定属于同一个人。请注意，即使两个账户具有相同的名称，
# 它们也可能属于不同的人，因为人们可能具有相同的名称。一个人最初可以拥有任意数量的账户，但其所有账户都具有相同的名称。
# 合并账户后，按以下格式返回账户：每个账户的第一个元素是名称，其余元素是按字符 ASCII 顺序排列的邮箱地址。账户本身可以以任意顺序返回。
#
# 示例 1：
# 输入：
# accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
# 输出：
# [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
# 解释：
# 第一个和第三个 John 是同一个人，因为他们有共同的邮箱地址 "johnsmith@mail.com"。
# 第二个 John 和 Mary 是不同的人，因为他们的邮箱地址没有被其他帐户使用。
# 可以以任何顺序返回这些列表，例如答案 [['Mary'，'mary@mail.com']，['John'，'johnnybravo@mail.com']，
# ['John'，'john00@mail.com'，'john_newyork@mail.com'，'johnsmith@mail.com']] 也是正确的。
#
# 提示：
#     accounts的长度将在[1，1000]的范围内。
#     accounts[i]的长度将在[1，10]的范围内。
#     accounts[i][j]的长度将在[1，30]的范围内。
import collections
from typing import List


class Solution:
    def accountsMerge(self, accounts: List[List[str]]) -> List[List[str]]:
        email_indexes = {}
        email_names = {}

        index = 0
        for account in accounts:
            name = account[0]
            for email in account[1:]:
                if email not in email_indexes:
                    email_indexes[email] = index
                    index += 1
                    email_names[email] = name

        union_find = UnionFind(index)

        for account in accounts:
            index_x = email_indexes[account[1]]
            for email in account[2:]:
                index_y = email_indexes[email]
                union_find.union(index_x, index_y)

        accounts_emails = collections.defaultdict(list)
        for email, index in email_indexes.items():
            index = union_find.find(index)
            accounts_emails[index].append(email)

        ans = list()
        for account_emails in accounts_emails.values():
            ans.append([email_names[account_emails[0]]] + sorted(account_emails))
        return ans


class UnionFind:
    def __init__(self, n):
        self.parent = list(range(n))

    def find(self, x: int) -> int:
        parent_x = self.parent[x]
        if parent_x != x:
            self.parent[x] = self.find(parent_x)
        return self.parent[x]

    def union(self, x: int, y: int):
        self.parent[self.find(x)] = self.find(y)
