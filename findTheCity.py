import heapq

class Solution:
    def findTheCity(self, n, edges, distanceThreshold):
        adj = [[] for _ in range(n)]

        for edge in edges:
            u, v, wt = edge[0], edge[1], edge[2]
            adj[u].append((v, wt))
            adj[v].append((u, wt))

        cnt = float('inf')
        city = -1

        for k in range(n):
            distance = [float('inf')] * n
            distance[k] = 0

            pq = [(0, k)]

            while pq:
                cost, node = heapq.heappop(pq)

                if distance[node] < cost:
                    continue

                for neighbor in adj[node]:
                    to, wt = neighbor[0], neighbor[1]

                    if distance[to] > distance[node] + wt:
                        distance[to] = distance[node] + wt
                        heapq.heappush(pq, (distance[to], to))

            count = sum(1 for d in distance if d <= distanceThreshold)

            if count <= cnt:
                cnt = count
                city = k

        return city
