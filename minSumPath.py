import sys
sys.setrecursionlimit(1000000)

def minPathSum(i, j, grid, dp):
    # Base case-1
    if i == 0 and j == 0:
        return grid[i][j]

    # Base case-2
    if i < 0 or j < 0:
        return 10000007

    # Memoization case
    if dp[i][j] != -1:
        return dp[i][j]

    # Recur for the path in 0 to i-1
    up = grid[i][j] + minPathSum(i-1, j, grid, dp)

    # Recur for the path in 0 to j-1
    left = grid[i][j] + minPathSum(i, j-1, grid, dp)

    # Return the result
    dp[i][j] = min(up, left)
    return dp[i][j]

n, m = map(int, input().split())
grid = []
for i in range(n):
    row = list(map(int, input().split()))
    grid.append(row)

dp = [[-1 for j in range(m)] for i in range(n)]
print(minPathSum(n-1, m-1, grid, dp))
