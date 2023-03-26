from typing import List, Dict, Tuple

class LRUCache:

    def __init__(self, capacity: int):
        self.n = capacity
        self.dll = []
        self.mp = {}

    def makeRecentlyUsed(self, key: int) -> None:
        self.dll.remove(self.mp[key][0])
        self.dll.insert(0, key)
        self.mp[key] = (self.dll.index(key), self.mp[key][1])

    def get(self, key: int) -> int:
        if key not in self.mp:
            return -1
        self.makeRecentlyUsed(key)
        return self.mp[key][1]

    def put(self, key: int, value: int) -> None:
        if key in self.mp:
            self.mp[key] = (self.mp[key][0], value)
            self.makeRecentlyUsed(key)
        else:
            self.dll.insert(0, key)
            self.mp[key] = (self.dll.index(key), value)
            self.n -= 1
        if self.n < 0:
            keyToBeDeleted = self.dll.pop()
            del self.mp[keyToBeDeleted]
            self.n += 1
