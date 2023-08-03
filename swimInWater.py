import heapq

class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        n = len(grid)
        m = len(grid[0])

        pq = []
        heapq.heappush(pq, [grid[0][0], 0, 0])

        vis = [[0] * m for _ in range(n)]
        vis[0][0] = 1

        dr = [0, -1, 0, 1, 0]

        while pq:
            top = heapq.heappop(pq)

            t = top[0]
            x, y = top[1], top[2]

            if x == n - 1 and y == m - 1:
                return t

            for i in range(4):
                nx = x + dr[i]
                ny = y + dr[i + 1]

                if 0 <= nx < n and 0 <= ny < m and vis[nx][ny] == 0:
                    vis[nx][ny] = 1
                    heapq.heappush(pq, [max(t, grid[nx][ny]), nx, ny])

        return -1
