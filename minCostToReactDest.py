import heapq
from collections import defaultdict

class Solution:
    def minCost(self, grid):
        n = len(grid)
        m = len(grid[0])

        cost = [[float('inf')] * m for _ in range(n)]
        cost[0][0] = 0
        pq = [(0, 0, 0)]

        dirs = [0, 1, 0, -1, 0]

        mpDir = defaultdict(int)
        mpDir[(0, 1)] = 1
        mpDir[(1, 0)] = 3
        mpDir[(0, -1)] = 2
        mpDir[(-1, 0)] = 4

        while pq:
            top = heapq.heappop(pq)
            x, y, cur_cost = top

            if x == n - 1 and y == m - 1:
                return cost[x][y]

            if cur_cost > cost[x][y]:
                continue

            for i in range(4):
                new_x = x + dirs[i]
                new_y = y + dirs[i + 1]

                if 0 <= new_x < n and 0 <= new_y < m:
                    dir_cost = 0

                    if grid[x][y] != mpDir[(dirs[i], dirs[i + 1])]:
                        dir_cost = 1

                    new_cost = cur_cost + dir_cost

                    if new_cost < cost[new_x][new_y]:
                        cost[new_x][new_y] = new_cost
                        heapq.heappush(pq, (new_cost, new_x, new_y))

        return cost[n - 1][m - 1]
