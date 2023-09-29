class Solution:
    def __init__(self):
        self.cnt = 0
        self.dr = [0, 1, 0, -1, 0]

    def dfs(self, i, j, r, c, vis, grid):
        vis[i][j] = True
        self.cnt += 1

        for k in range(4):
            nx = i + self.dr[k]
            ny = j + self.dr[k + 1]

            if 0 <= nx < r and 0 <= ny < c and not vis[nx][ny] and grid[nx][ny] == 1:
                self.dfs(nx, ny, r, c, vis, grid)

    def maxAreaOfIsland(self, grid):
        n = len(grid)
        m = len(grid[0])

        vis = [[False] * m for _ in range(n)]

        ans = 0

        for i in range(n):
            for j in range(m):
                if not vis[i][j] and grid[i][j] == 1:
                    self.cnt = 0
                    self.dfs(i, j, n, m, vis, grid)
                    ans = max(self.cnt, ans)

        return ans
