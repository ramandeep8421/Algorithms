class Solution:
    def binary_search(self, n, a, target):
        lo = 0
        hi = n - 1

        while lo <= hi:
            mid = lo + (hi - lo) // 2

            if a[mid] == target:
                return mid
            elif a[mid] > target:
                hi = mid - 1
            else:
                lo = mid + 1

        return -1
