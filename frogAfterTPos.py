class Solution:
    def __init__(self):
        self.prob = 0
        self.target = 0
        self.adjList = []
        self.visited = []

    def dfs(self, i, t):
        if i != 1 and len(self.adjList[i]) == 1 or t == 0:
            return 1 if i == self.target else 0

        self.visited[i] = True

        res = 0

        for j in self.adjList[i]:
            if not self.visited[j]:
                res += self.dfs(j, t - 1)

        return res / (len(self.adjList[i]) - (i != 1))

    def frogPosition(self, n, edges, t, target):
        self.adjList = [[] for _ in range(n+1)]
        self.visited = [False] * (n+1)

        self.target = target

        for u in edges:
            self.adjList[u[0]].append(u[1])
            self.adjList[u[1]].append(u[0])

        return self.dfs(1, t)
