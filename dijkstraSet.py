import heapq
from typing import List

class Solution:
    def dijkstra(self, V: int, adj: List[List[List[int]]], S: int) -> List[int]:
        INF = 1_000_000_000
        distance = [INF] * (V + 1)
        distance[S] = 0

        heap = [(0, S)]

        while heap:
            dist, u = heapq.heappop(heap)

            if distance[u] < dist:
                continue

            for neighbor in adj[u]:
                to, wt = neighbor[0], neighbor[1]

                if distance[to] > wt + distance[u]:
                    distance[to] = wt + distance[u]
                    heapq.heappush(heap, (distance[to], to))

        return distance
