import heapq

class Solution:
    def countPaths(self, n, roads):
        MOD = 10**9 + 7
        distance = [float('inf')] * n
        ways = [0] * n

        distance[0] = 0
        adj = [[] for _ in range(n)]

        for it in roads:
            adj[it[0]].append((it[1], it[2]))
            adj[it[1]].append((it[0], it[2]))

        pq = [(0, 0)]
        ways[0] = 1

        while pq:
            dist, node = heapq.heappop(pq)

            if distance[node] < dist:
                continue

            for to, wt in adj[node]:
                if distance[to] > dist + wt:
                    distance[to] = dist + wt
                    ways[to] = ways[node]
                    heapq.heappush(pq, (distance[to], to))
                elif distance[to] == dist + wt:
                    ways[to] = (ways[to] + ways[node]) % MOD

        return ways[n-1] % MOD
