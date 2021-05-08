# 155. 最小栈 [栈]
class MinStack:

    def __init__(self):
        self.min_stack = []
        self.value_stack = []
        """
        initialize your data structure here.
        """

    def push(self, val: int) -> None:
        self.value_stack.append(val)
        if not self.min_stack or self.min_stack[-1] >= val:
            self.min_stack.append(val)

    def pop(self) -> None:
        if self.value_stack:
            val = self.value_stack.pop()
            if self.min_stack[-1] == val:
                self.min_stack.pop()

    def top(self) -> int:
        return self.value_stack[-1]

    def getMin(self) -> int:
        return self.min_stack[-1]