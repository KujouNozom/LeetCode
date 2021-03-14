# 706. 设计哈希映射 [简单]
class MyHashMap:
    def __init__(self):
        self.base_array = [[] for _ in range(100000)]

    def put(self, key: int, value: int) -> None:
        value_array = self.get_value_array(key)
        is_find = False
        for index, data in enumerate(value_array):
            if data[0] == key:
                value_array[index] = (key, value)
                is_find = True

        if not is_find:
            value_array.append((key, value))

    def get(self, key: int) -> int:
        value_array = self.get_value_array(key)
        for index, data in enumerate(value_array):
            if data[0] == key:
                return data[1]

        return -1

    def remove(self, key: int) -> None:
        value_array = self.get_value_array(key)
        remove_index = -1
        for index, data in enumerate(value_array):
            if data[0] == key:
                remove_index = index
                break

        if remove_index != -1:
            value_array.pop(remove_index)

    def get_value_array(self, key: int) -> list:
        hash_key = key % 100000
        return self.base_array[hash_key]
