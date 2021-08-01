# 1418. 点菜展示表 [Hash,排序]
import collections
from typing import List


class Solution:
    def displayTable(self, orders: List[List[str]]) -> List[List[str]]:
        food_set = set()
        tables = collections.defaultdict(dict)
        for order in orders:
            table_num, food = int(order[1]), order[2]
            food_set.add(food)
            table_info = tables[table_num]
            table_info[food] = table_info.get(food, 0) + 1

        head = sorted(list(food_set))
        ans = [['Table'] + head]
        indexes = sorted(tables.keys())
        for index in indexes:
            table_info = tables[index]
            temp = [str(index)]
            for col in head:
                temp.append(str((table_info.get(col, 0))))
            ans.append(temp)
        return ans
