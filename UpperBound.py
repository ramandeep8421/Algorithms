class Solution:
    def upper_bound(self, n, a, target):
        lo = 0
        hi = n - 1
        ans = n

        while lo <= hi:
            mid = lo + (hi - lo) // 2

            if a[mid] > target:
                ans = mid
                hi = mid - 1
            else:
                lo = mid + 1

        return ans
