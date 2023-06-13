class Solution:
    def shortestTime(self, n, t, nums):
        lo = 0
        hi = int(1e18)

        ans = 0

        while lo <= hi:
            mid = lo + (hi - lo) // 2

            noOfProducts = 0

            for i in range(n):
                noOfProducts += mid // nums[i]
                if noOfProducts >= t:
                    break

            if noOfProducts >= t:
                ans = mid
                hi = mid - 1
            else:
                lo = mid + 1

        return ans
