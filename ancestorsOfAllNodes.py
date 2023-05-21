class Solution:
    def dfs(self, x, curr, ans, graph):
        for it in graph[curr]:
            if len(graph[it]) == 0 or graph[it][-1] != x:
                ans[it].append(x)
                self.dfs(x, it, ans, graph)
    
    def getAncestor(self, n, edges):
        graph = [[] for _ in range(n)]
        ans = [[] for _ in range(n)]
    
        for it in edges:
            graph[it[0]].append(it[1])
    
        for i in range(n):
            self.dfs(i, i, ans, graph)
    
        return ans
