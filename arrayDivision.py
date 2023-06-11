class Solution:
    def isValid(self, a, k, mid):
        groups = 0
        summ = 0
        n = len(a)

        for i in range(n):
            if a[i] > mid:
                return False

            if summ + a[i] > mid:
                groups += 1
                summ = 0
            summ += a[i]

        if summ > 0:
            groups += 1

        return groups <= k

    def arrayDivision(self, a, k):
        lo = 0
        hi = 0
        ans = 0

        for num in a:
            hi += num

        while lo <= hi:
            mid = (hi + lo) // 2

            if self.isValid(a, k, mid):
                hi = mid - 1
                ans = mid
            else:
                lo = mid + 1

        return ans


obj = Solution()

n, k = map(int, input().split())
a = list(map(int, input().split()))

print(obj.arrayDivision(a, k))
