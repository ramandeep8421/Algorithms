class Solution:
    def minimizedMaximum(self, quantities, n):
        lo = 1
        hi = 100000

        while lo < hi:
            mid = lo + (hi - lo) // 2
            total = sum((it + mid + 1) // mid for it in quantities)  # ceil(it/mid)

            if total > n:
                lo = mid + 1  # [mid+1, hi]
            else:
                hi = mid  # [lo, mid]

        return lo

