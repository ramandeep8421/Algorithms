from collections import deque

class Solution:
    def dfs(self, node, color, vis, graph):
        vis[node] = color
        for child in graph[node]:
            if vis[child] == -1:
                check = self.dfs(child, not color, vis, graph)
                if not check:
                    return False
            else:
                if vis[child] == vis[node]:
                    return False
        return True

    def isBipartite(self, graph):
        n = len(graph)
        vis = [-1] * n

        for i in range(n):
            if vis[i] == -1:
                check = self.dfs(i, 0, vis, graph)
                if not check:
                    return False

        return True

# Example usage:
# sol = Solution()
# graph = [[1, 3], [0, 2], [1, 3], [0, 2]]
# result = sol.isBipartite(graph)
# print(result)
