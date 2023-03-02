import sys

sys.setrecursionlimit(100000)

def knapsackRec(wt, val, W, n, dp):
    # base case
    if n == 0 or W == 0:
        return 0

    # when the item is not fittable in the given capacity
    if W - wt[n-1] < 0:
        dp[n-1][W] = knapsackRec(wt, val, W, n-1, dp)
        return dp[n-1][W]

    # if the solution of the problem is already evaluated
    if dp[n-1][W] != -1:
        return dp[n-1][W]

    # if fittable then do the exhaustive search for both options and take max of them...
    dp[n-1][W] = max(val[n-1] + knapsackRec(wt, val, W-wt[n-1], n-1, dp), knapsackRec(wt, val, W, n-1, dp))
    return dp[n-1][W]

def knapsack(wt, val, W, n):
    # use a double pointer to declare the table dynamically
    dp = [[-1 for j in range(W+1)] for i in range(n)]

    return knapsackRec(wt, val, W, n, dp)


# driver code
if __name__ == "__main__":
    W, n = map(int, input().split())
    wt = list(map(int, input().split()))
    val = list(map(int, input().split()))
    print(knapsack(wt, val, W, n))
