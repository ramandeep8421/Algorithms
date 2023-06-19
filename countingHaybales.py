from typing import List, Tuple

class Solution:
    def countHaybales(self, haybales: List[int], queries: List[Tuple[int, int]]):
        n = len(haybales)
        Q = len(queries)

        haybales.sort()

        for query in queries:
            ub = self.upperBound(haybales, query[1])
            lb = self.lowerBound(haybales, query[0])

            print(ub - lb)

    def upperBound(self, haybales: List[int], target: int) -> int:
        low = 0
        high = len(haybales)

        while low < high:
            mid = low + (high - low) // 2

            if haybales[mid] <= target:
                low = mid + 1
            else:
                high = mid

        return low

    def lowerBound(self, haybales: List[int], target: int) -> int:
        low = 0
        high = len(haybales)

        while low < high:
            mid = low + (high - low) // 2

            if haybales[mid] < target:
                low = mid + 1
            else:
                high = mid

        return low
