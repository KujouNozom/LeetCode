# 341. 扁平化嵌套列表迭代器 [递归]
class NestedInteger:
    def isInteger(self) -> bool:
        """
        @return True if this NestedInteger holds a single integer, rather than a nested list.
        """

    def getInteger(self) -> int:
        """
        @return the single integer that this NestedInteger holds, if it holds a single integer
        Return None if this NestedInteger holds a nested list
        """

    def getList(self) -> list:
        """
        @return the nested list that this NestedInteger holds, if it holds a nested list
        Return None if this NestedInteger holds a single integer
        """


def getValues(values: [NestedInteger], data: list):
    for value in values:
        if value.isInteger():
            data.append(value.getInteger())
        else:
            getValues(value.getList(), data)


class NestedIterator:
    def __init__(self, nestedList: [NestedInteger]):
        self.data = []
        getValues(nestedList, self.data)
        self.index = 0

    def next(self) -> int:
        value = self.data[self.index]
        self.index += 1
        return value

    def hasNext(self) -> bool:
        return self.index < len(self.data)
