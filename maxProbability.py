import heapq

class Solution:
    def maxProbability(self, n: int, edges: List[List[int]], succProb: List[float], start: int, end: int) -> float:
        ans = 0
        q = [(-1, start)]
        adj = [[] for _ in range(n)]
        for i in range(len(edges)):
            u, v, w = edges[i][0], edges[i][1], succProb[i]
            adj[u].append((v, w))
            adj[v].append((u, w))
        probability = [0] * n
        probability[start] = 1
        while q:
            cnt, pos = heapq.heappop(q)
            cnt = -cnt
            if pos == end:
                ans = max(ans, cnt)
            for it in adj[pos]:
                neighbor, weight = it
                if cnt * weight > probability[neighbor]:
                    probability[neighbor] = cnt * weight
                    heapq.heappush(q, (-probability[neighbor], neighbor))
        return ans
