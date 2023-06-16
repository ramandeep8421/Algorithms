class Solution:
    def maxTeams(self, c, m, x):
        lo = 0
        hi = min(c, m)
        ans = 0

        while lo <= hi:
            mid = lo + (hi - lo) // 2

            if c + m + x - 2 * mid >= mid:
                lo = mid + 1
                ans = mid
            else:
                hi = mid

        return ans

solution = Solution()
c = 10  # replace with your desired value
m = 8   # replace with your desired value
x = 4   # replace with your desired value
result = solution.maxTeams(c, m, x)
print("Maximum number of teams:", result)

