# 1600. 皇位继承顺序 [树，DFS]
import collections
from typing import List


class ThroneInheritance:

    def __init__(self, kingName: str):
        self.king = kingName
        self.persons = collections.defaultdict(list)
        self.dead = set()

    def birth(self, parentName: str, childName: str) -> None:
        self.persons[parentName].append(childName)

    def death(self, name: str) -> None:
        self.dead.add(name)

    def getInheritanceOrder(self) -> List[str]:
        ans = []
        self.backtrace(self.king, ans)
        return ans

    def backtrace(self, name: str, ans: List[str]) -> None:
        if name not in self.dead:
            ans.append(name)
        if self.persons[name]:
            for children in self.persons[name]:
                self.backtrace(children, ans)
