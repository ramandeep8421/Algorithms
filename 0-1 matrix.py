from typing import List
from queue import Queue

class Solution:
    DIR = [0, 1, 0, -1, 0]
    
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        m, n = len(mat), len(mat[0])
        q = Queue()
        for r in range(m):
            for c in range(n):
                if mat[r][c] == 0:
                    q.put((r, c))
                else:
                    mat[r][c] = -1 # Marked as not processed yet!

        while not q.empty():
            r, c = q.get()
            for i in range(4):
                nr, nc = r + self.DIR[i], c + self.DIR[i+1]
                if nr < 0 or nr == m or nc < 0 or nc == n or mat[nr][nc] != -1:
                    continue
                mat[nr][nc] = mat[r][c] + 1
                q.put((nr, nc))
        return mat

if __name__ == '__main__':
    n, m = map(int, input().split())
    matrix = []
    for i in range(n):
        matrix.append(list(map(int, input().split())))
    obj = Solution()
    res = obj.updateMatrix(matrix)
    for row in res:
        print(*row)
