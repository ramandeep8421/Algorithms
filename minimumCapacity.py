 class Solution:
    def isValid(self, weights, capacity, days):
        total_sum = 0
        count = 1
        for weight in weights:
            if total_sum + weight > capacity:
                count += 1
                total_sum = 0

            total_sum += weight

        return count <= days

    def minimumCapacity(self, weights, days):
        n = len(weights)

        lo = 0
        hi = 0

        for weight in weights:
            lo = max(lo, weight)
            hi += weight

        while lo <= hi:
            mid = lo + (hi - lo) // 2

            if self.isValid(weights, mid, days):
                hi = mid
            else:
                lo = mid + 1

        return lo
