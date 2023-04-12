class Solution:
    def uniquePathsIII(self, grid: List[List[int]]) -> int:
        # variable to store the final answer
        ans = 0

        # direction vectors
        dr = [-1, 0, 1, 0]
        dc = [0, 1, 0, -1]

        # function to check for the visited cells
        def check(grid, vis):
            n, m = len(grid), len(grid[0])
            for i in range(n):
                for j in range(m):
                    if grid[i][j] == 0 and not vis[i][j]:
                        return False
            return True

        # dfs function to perform the traversal
        def dfs(i, j, x, y, grid, vis):
            n, m = len(grid), len(grid[0])

            if i == x and j == y:
                vis[i][j] = True
                if check(grid, vis):
                    nonlocal ans
                    ans += 1
                vis[i][j] = False
                return

            vis[i][j] = True
            for k in range(4):
                newr, newc = i + dr[k], j + dc[k]
                if newr < 0 or newr >= n or newc < 0 or newc >= m or grid[newr][newc] == -1 or vis[newr][newc]:
                    continue
                dfs(newr, newc, x, y, grid, vis)
            vis[i][j] = False

        n, m = len(grid), len(grid[0])
        vis = [[False] * m for _ in range(n)]

        # Find the start and end points
        for i in range(n):
            for j in range(m):
                if grid[i][j] == 1:
                    sr, sc = i, j
                elif grid[i][j] == 2:
                    er, ec = i, j

        dfs(sr, sc, er, ec, grid, vis)
        return ans

