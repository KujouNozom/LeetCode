# 705. 设计哈希集合 [数组]
class MyHashSet:
    def __init__(self):
        self.base_array = [[] for _ in range(50)]

    def add(self, key: int) -> None:
        value_list = self.get_value_list(key)
        if key not in value_list:
            value_list.append(key)

    def remove(self, key: int) -> None:
        value_list = self.get_value_list(key)
        if key in value_list:
            value_list.remove(key)

    def contains(self, key: int) -> bool:
        return key in self.get_value_list(key)

    def get_value_list(self, key: int):
        hash_key = key % 50
        return self.base_array[hash_key]
