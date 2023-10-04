class Solution:
    def allPathsSourceTarget(self, graph: list[list[int]]) -> list[list[int]]:
        target = len(graph) - 1
        source = 0
        path = []
        ans = []
        self.dfs(graph, source, target, path, ans)
        return ans

    def dfs(self, graph: list[list[int]], source: int, target: int, path: list[int], ans: list[list[int]]):
        if source == target:
            path.append(source)
            ans.append(path.copy())
            path.pop()
            return

        path.append(source)

        for neighbor in graph[source]:
            self.dfs(graph, neighbor, target, path, ans)

        path.pop()

# Example usage:
# solution = Solution()
# graph = [[1, 2], [3], [3], []]
# result = solution.allPathsSourceTarget(graph)
# print(result)
