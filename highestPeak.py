from typing import List
from collections import deque

class Solution:
    def highestPeak(self, water: List[List[int]]) -> List[List[int]]:
        n = len(water)
        m = len(water[0])

        ans = [[-1] * m for _ in range(n)]

        qu = deque()

        for i in range(n):
            for j in range(m):
                if water[i][j] == 1:
                    ans[i][j] = 0
                    qu.append((i, j))

        directions = [(-1, 0), (0, 1), (1, 0), (0, -1)]

        while qu:
            x, y = qu.popleft()

            v = ans[x][y]

            for dx, dy in directions:
                new_x = x + dx
                new_y = y + dy

                if 0 <= new_x < n and 0 <= new_y < m and ans[new_x][new_y] == -1:
                    ans[new_x][new_y] = v + 1
                    qu.append((new_x, new_y))

        return ans
