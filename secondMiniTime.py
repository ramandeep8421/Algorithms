from collections import defaultdict
import heapq


class Solution:
    def secondMinimum(self, n, edges, time, change):
        adj = defaultdict(list)
        for edge in edges:
            a, b = edge[0], edge[1]
            adj[a].append(b)
            adj[b].append(a)

        dist1 = [float('inf')] * (n + 1)
        dist2 = [float('inf')] * (n + 1)
        freq = [0] * (n + 1)

        pq = []
        heapq.heappush(pq, [1, 0])
        dist1[1] = 0

        while pq:
            node, time_taken = heapq.heappop(pq)

            freq[node] += 1

            if freq[node] == 2 and node == n:
                return time_taken

            if (time_taken // change) % 2 == 1:
                time_taken = change * ((time_taken // change) + 1) + time
            else:
                time_taken += time

            if node not in adj:
                continue

            for neighbor in adj[node]:
                if freq[neighbor] == 2:
                    continue

                if dist1[neighbor] > time_taken:
                    dist2[neighbor] = dist1[neighbor]
                    dist1[neighbor] = time_taken
                    heapq.heappush(pq, [neighbor, time_taken])
                elif dist2[neighbor] > time_taken and dist1[neighbor] != time_taken:
                    dist2[neighbor] = time_taken
                    heapq.heappush(pq, [neighbor, time_taken])

        return 0
