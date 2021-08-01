# 65. 有效数字 [正则表达式]
from typing import re


class Solution:
    def isNumber(self, s: str) -> bool:
        return bool(re.fullmatch(r'[+-]?(\d+\.?\d*|\.\d+)([e|E][+-]?\d+)?', s))
