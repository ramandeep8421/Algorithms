from collections import deque

class Solution:
    def validPath(self, n: int, edges: List[List[int]], source: int, destination: int) -> bool:
        graph = {}

        for edge in edges:
            if edge[0] not in graph:
                graph[edge[0]] = []
            if edge[1] not in graph:
                graph[edge[1]] = []
            graph[edge[0]].append(edge[1])
            graph[edge[1]].append(edge[0])

        seen = [False] * n
        seen[source] = True

        queue = deque()
        queue.append(source)

        while queue:
            node = queue.popleft()

            if node == destination:
                return True

            for neighbor in graph[node]:
                if not seen[neighbor]:
                    seen[neighbor] = True
                    queue.append(neighbor)

        return False
