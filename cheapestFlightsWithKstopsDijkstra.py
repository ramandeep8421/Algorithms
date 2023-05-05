import heapq
from typing import List
from math import inf

class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        # adjacency list for storing the graph
        adj = [[] for _ in range(n)]

        # prepare the adjacency list
        for e in flights:
            adj[e[0]].append((e[1], e[2]))

        # stops array to count the number
        stops = [inf] * n

        pq = [(0, src, 0)]

        while pq:
            dist, node, steps = heapq.heappop(pq)

            if steps > stops[node] or steps > k + 1:
                continue

            stops[node] = steps

            if node == dst:
                return dist

            for neighbor, price in adj[node]:
                heapq.heappush(pq, (dist + price, neighbor, steps + 1))

        return -1
