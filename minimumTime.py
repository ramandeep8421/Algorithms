import heapq

class Solution:
    def minimumTime(self, grid):
        n = len(grid)
        m = len(grid[0])

        if min(grid[0][1], grid[1][0]) > 1:
            return -1

        dist = [[float('inf')] * m for _ in range(n)]
        dist[0][0] = 0

        pq = []
        heapq.heappush(pq, [0, 0, 0])

        dr = [0, -1, 0, 1, 0]

        while pq:
            time, x, y = heapq.heappop(pq)

            for i in range(4):
                nx = x + dr[i]
                ny = y + dr[i + 1]

                if min(nx, ny) >= 0 and nx < n and ny < m:
                    nTime = time + 1

                    if nTime < grid[nx][ny]:
                        nTime = grid[nx][ny] + (grid[nx][ny] - nTime) % 2

                    if nTime < dist[nx][ny]:
                        dist[nx][ny] = nTime
                        heapq.heappush(pq, [nTime, nx, ny])

        return dist[-1][-1]


# Example usage
solution = Solution()
grid = [
    [0, 2, 4],
    [3, 2, 1],
    [1, 1, 0]
]
result = solution.minimumTime(grid)
print("Minimum Time:", result)
