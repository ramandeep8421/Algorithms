import heapq

class Pair:
    def __init__(self, distance, node):
        self.distance = distance
        self.node = node

class Solution:
    @staticmethod
    def dijkstra(N, adj, src):
        distance = [float('inf')] * N
        distance[src] = 0

        pq = []
        heapq.heappush(pq, Pair(0, src))

        while pq:
            pair = heapq.heappop(pq)
            dist = pair.distance
            node = pair.node

            if distance[node] < dist:
                continue

            for i in range(len(adj[node])):
                adjNode = adj[node][i][0]
                edgeWeight = adj[node][i][1]

                if distance[adjNode] > dist + edgeWeight:
                    distance[adjNode] = dist + edgeWeight
                    heapq.heappush(pq, Pair(distance[adjNode], adjNode))

        return distance
