class Solution:
    def max(self, a, b):
        return a if a > b else b

    def isValid(self, x, h, w, n):
        a = x // h
        b = x // w

        return (a * b) >= n

    def minRectanglesInSquare(self, h, w, n):
        l = 0
        r = 1

        while not self.isValid(r, h, w, n):
            r *= 2

        while l < r:
            mid = l + (r - l) // 2

            if self.isValid(mid, h, w, n):
                r = mid
            else:
                l = mid + 1

        return l
