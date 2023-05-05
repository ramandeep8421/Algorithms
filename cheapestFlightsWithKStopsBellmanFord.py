from typing import List
import sys

class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        dist = [sys.maxsize] * n
        dist[src] = 0

        for i in range(k+1):
            temp = list(dist)

            for flight in flights:
                if dist[flight[0]] != sys.maxsize:
                    temp[flight[1]] = min(temp[flight[1]], dist[flight[0]] + flight[2])

            dist = temp

        return dist[dst] if dist[dst] != sys.maxsize else -1
