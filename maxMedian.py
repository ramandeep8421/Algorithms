class Solution:

    def check(self, x, k, n, nums):
        operations = 0

        for i in range(n // 2, n):
            if x - nums[i] >= 0:
                operations += (x - nums[i])
            if operations > k:
                return False

        return operations <= k

    def maximumMedian(self, n, k, nums):
        lo = 1
        hi = 2000000000

        while lo <= hi:
            mid = lo + (hi - lo) // 2

            if self.check(mid, k, n, nums):
                lo = mid
            else:
                hi = mid - 1

        return lo
