import heapq
import sys

INF = sys.maxsize

class Pair:
    def __init__(self, node, cost):
        self.node = node
        self.cost = cost

def dijkstra(src, N, adj):
    distance = [INF] * (N + 1)
    distance[src] = 0

    pq = []
    heapq.heappush(pq, Pair(src, 0))

    while pq:
        p = heapq.heappop(pq)
        node = p.node
        cost = p.cost

        if distance[node] < cost:
            continue

        for neighbor in adj[node]:
            to = neighbor.node
            c = neighbor.cost

            if distance[to] > c + distance[node]:
                distance[to] = c + distance[node]
                heapq.heappush(pq, Pair(to, distance[to]))

    return distance

n, m = map(int, input().split())
adj = [[] for _ in range(n + 1)]
adjRev = [[] for _ in range(n + 1)]

for _ in range(m):
    a, b, c = map(int, input().split())
    adj[a].append(Pair(b, c))
    adjRev[b].append(Pair(a, c))

minCosts = dijkstra(1, n, adj)
minCostsRev = dijkstra(n, n, adjRev)

ans = INF

for i in range(1, n + 1):
    for neighbor in adj[i]:
        to = neighbor.node
        c = neighbor.cost

        if minCosts[i] == INF or minCostsRev[to] == INF:
            continue

        ans = min(ans, minCosts[i] + c // 2 + minCostsRev[to])

print(ans)
