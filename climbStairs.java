public class Solution {
    int[] dp = new int[51]; // Java uses 0-based indexing for arrays

    public int climbStairs(int n) {
        if (n < 2)
            return 1;

        if (dp[n] != 0)
            return dp[n];

        return dp[n] = climbStairs(n - 1) + climbStairs(n - 2);
    }
}
