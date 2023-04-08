from typing import List
from queue import Queue


class Solution:

    def isValid(self, x: int, y: int, n: int, m: int) -> bool:
        return x >= 0 and x <= n-1 and y >= 0 and y <= m-1

    def shortestPath(self, grid: List[List[int]], k: int) -> int:

        # find the dimensions of the grid
        n = len(grid)
        m = len(grid[0])

        # Direction vector
        dir = [0, 1, 0, -1, 0]

        steps = 0

        # lives array to optimize the use of obstacle removal power
        lives = [[-1 for j in range(m)] for i in range(n)]

        # Declare a queue to push the elements
        qu = Queue()

        qu.put([0, 0, k])

        while not qu.empty():

            size = qu.qsize()

            for i in range(size):

                row, col, currLives = qu.get()

                if row == n-1 and col == m-1:
                    return steps

                if grid[row][col] == 1:
                    currLives -= 1

                for i in range(4):
                    newRow = row + dir[i]
                    newCol = col + dir[i+1]

                    if self.isValid(newRow, newCol, n, m) and lives[newRow][newCol] < currLives:
                        lives[newRow][newCol] = currLives
                        qu.put([newRow, newCol, currLives])

            steps += 1

        return -1
