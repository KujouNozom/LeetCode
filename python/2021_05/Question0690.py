# 690. 员工的重要性 [递归]
from typing import List


class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates


class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        def function(employees_dict: dict, id: int):
            ans = 0
            current: Employee = employees_dict[id]
            if current:
                ans += current.importance
                for employee in current.subordinates:
                    ans += function(employees_dict, employee)
            return ans

        employees_dict = {x.id: x for x in employees}
        return function(employees_dict, id)
