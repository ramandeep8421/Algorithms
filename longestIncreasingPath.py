from collections import deque

class Solution:

    def kahnAlgorithm(self, n, m, adj, indegree):
        order = []
        q = deque()

        for i in range(n * m):
            if indegree[i] == 0:
                q.append(i)

        while q:
            node = q.popleft()
            order.append(node)

            for neighbor in adj[node]:
                indegree[neighbor] -= 1
                if indegree[neighbor] == 0:
                    q.append(neighbor)

        return order

    def longestIncreasingPath(self, matrix):
        n = len(matrix)
        m = len(matrix[0])

        adj = [[] for _ in range(n * m)]
        indegree = [0] * (n * m)

        dir = [0, -1, 0, 1, 0]

        for i in range(n):
            for j in range(m):
                for k in range(4):
                    x = i + dir[k]
                    y = j + dir[k + 1]

                    if 0 <= x < n and 0 <= y < m and matrix[x][y] > matrix[i][j]:
                        adj[i * m + j].append(x * m + y)
                        indegree[x * m + y] += 1

        order = self.kahnAlgorithm(n, m, adj, indegree)

        dp = [1] * (n * m)

        for it in order:
            for edge in adj[it]:
                dp[edge] = max(dp[edge], dp[it] + 1)

        return max(dp)
