class Solution:
    def exist(self, b: List[List[str]], w: str) -> bool:
        n = len(b)
        m = len(b[0])

        for i in range(n):
            for j in range(m):
                if b[i][j] == w[0]:
                    t = b[i][j]
                    b[i][j] = '1'
                    if self.solve(i, j, n, m, 1, w, b):
                        return True
                    b[i][j] = t

        return False

    def solve(self, i: int, j: int, n: int, m: int, in_: int, w: str, b: List[List[str]]) -> bool:
        if in_ == len(w):
            return True

        dir_ = [0, 1, 0, -1, 0]

        for k in range(4):
            nx = i + dir_[k]
            ny = j + dir_[k+1]
            
            if nx < 0 or ny < 0 or nx >= n or ny >= m or b[nx][ny] == '1' or b[nx][ny] != w[in_]:
                continue

            t = b[nx][ny]
            b[nx][ny] = '1'

            if self.solve(nx, ny, n, m, in_+1, w, b):
                return True

            b[nx][ny] = t

        return False
