class Solution:
    dp = [0] * 51  # Using a list to mimic the behavior of an array in C++

    def climbStairs(self, n: int) -> int:
        if n < 2:
            return 1

        if Solution.dp[n] != 0:
            return Solution.dp[n]

        Solution.dp[n] = self.climbStairs(n - 1) + self.climbStairs(n - 2)
        return Solution.dp[n]
