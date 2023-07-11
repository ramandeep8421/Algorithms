import heapq

INF = 1000000000000000

def dijkstra(N, adj):
    distance = [INF] * N

    distance[0] = 0

    pq = []
    heapq.heappush(pq, (0, 0))

    while pq:
        dist, node = heapq.heappop(pq)

        if dist > distance[node]:
            continue

        for neighbor in adj[node]:
            to, weight = neighbor

            if distance[to] > dist + weight:
                distance[to] = dist + weight
                heapq.heappush(pq, (distance[to], to))

    for i in range(N):
        print(distance[i], end=" ")

if __name__ == "__main__":
    N, M = map(int, input().split())

    adj = [[] for _ in range(N)]

    for _ in range(M):
        a, b, c = map(int, input().split())
        a -= 1
        b -= 1
        adj[a].append((b, c))

    dijkstra(N, adj)
