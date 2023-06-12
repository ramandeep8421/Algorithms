class Solution:
    def shortestTimeNeeded(self, n, t, nums):
        lo = 0
        hi = n - 1
        ans = 0

        while lo <= hi:
            mid = lo + (hi - lo) // 2
            sum = 0
            for i in range(n):
                sum += mid // nums[i]
                if sum >= t:
                    break

            if sum >= t:
                ans = mid
                hi = mid - 1
            else:
                lo = mid + 1

        return ans
