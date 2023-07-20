import heapq

class Solution:
    def shortestPathBinaryMatrix(self, grid):
        n = len(grid)

        if n == 1 and grid[0][0] == 0:
            return 1
        
        if grid[0][0] + grid[n-1][n-1] != 0:
            return -1

        pq = []
        heapq.heappush(pq, [1, 0, 0])

        dist = [[1e9 for _ in range(n)] for _ in range(n)]
        dist[0][0] = 1

        dr = [-1, 0, 1, 0, 1, 1, -1, -1]
        dc = [0, 1, 0, -1, 1, -1, 1, -1]

        while pq:
            dis, x, y = heapq.heappop(pq)

            for i in range(8):
                newr = x + dr[i]
                newc = y + dc[i]

                if 0 <= newr < n and 0 <= newc < n and grid[newr][newc] == 0 and dis + 1 < dist[newr][newc]:
                    dist[newr][newc] = 1 + dis

                    if newr == n-1 and newc == n-1:
                        return 1 + dis

                    heapq.heappush(pq, [1 + dis, newr, newc])

        return -1

# Example usage:
# solution = Solution()
# grid = [[0, 1, 0], [0, 0, 1], [1, 1, 0]]
# print(solution.shortestPathBinaryMatrix(grid))
