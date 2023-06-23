class Solution:
    def minimalDays(self, sx, sy, ex, ey, s):
        n = len(s)

        direction = "UDLR"

        dx = [0, 0, -1, 1]
        dy = [1, -1, 0, 0]

        d = [(0, 0)] * 100009

        for i in range(n):
            id = -1

            for j in range(4):
                if direction[j] == s[i]:
                    id = j

            assert id != -1

            d[i + 1] = (d[i][0] + dx[id], d[i][1] + dy[id])

        l = 0
        r = int(1e18)

        while r - l > 1:
            mid = (l + r) // 2

            cycles = mid // n
            rem = mid % n

            x = sx + d[rem][0] + cycles * d[n][0]
            y = sy + d[rem][1] + cycles * d[n][1]

            dist = abs(x - ex) + abs(y - ey)

            if dist <= mid:
                r = mid
            else:
                l = mid

        if r >= 1e17:
            r = -1

        return r
