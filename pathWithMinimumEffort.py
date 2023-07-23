import heapq

class Solution:
    def minimumEffortPath(self, heights: List[List[int]]) -> int:
        n = len(heights)
        m = len(heights[0])

        distance = [[float('inf')] * m for _ in range(n)]

        distance[0][0] = 0

        pq = [(0, 0, 0)]

        directions = [0, 1, 0, -1, 0]

        while pq:
            effort, x, y = heapq.heappop(pq)

            if distance[x][y] < effort:
                continue

            if n - 1 == x and m - 1 == y:
                return effort

            for i in range(4):
                newx = x + directions[i]
                newy = y + directions[i + 1]

                if 0 <= newx < n and 0 <= newy < m:
                    neffort = max(effort, abs(heights[newx][newy] - heights[x][y]))
                    if neffort < distance[newx][newy]:
                        distance[newx][newy] = neffort
                        heapq.heappush(pq, (neffort, newx, newy))

        return 0
