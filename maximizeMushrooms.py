class Solution:
    def check(self, v, k, mid):
        n = len(v)
        if k < n:
            res = 0
            for i in range(k):
                res += v[i]

            curr_sum = res

            for i in range(k, n):
                curr_sum += (v[i] - v[i - k])
                res = max(res, curr_sum)

            res += (k + (k - 1)) // 2

            return res >= mid

        sum = 0

        for it in v:
            sum += it

        sum += (n * k)

        sum -= (n * (n + 1)) // 2

        return sum >= mid

    def maximizeMushrooms(self, v, k):
        lo = 1
        hi = int(1e18)

        while lo < hi:
            mid = lo + (hi - lo) // 2

            if self.check(v, k, mid):
                lo = mid
            else:
                hi = mid - 1

        return lo
