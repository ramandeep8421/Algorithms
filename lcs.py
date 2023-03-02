dp = [[-1 for i in range(1011)] for j in range(1011)]

def lcs(X, Y, n, m):
    # base case
    if n == 0 or m == 0:
        return 0
    
    # If the last characters are matching, lcs increases by 1
    if X[n-1] == Y[m-1]:
        dp[n][m] = 1 + lcs(X, Y, n-1, m-1)
        return dp[n][m]
    
    # If the result for the indices n and m 
    # are already memoized then return the result
    if dp[n][m] != -1:
        return dp[n][m]
    
    # Take the maximum of the result 
    # obtained from the two cases
    # case-1: lcs of X[0..n-1] and Y[0...m]
    # case-2: lcs of Y[0...m-1] and Y[0...n]
    dp[n][m] = max(lcs(X, Y, n-1, m), lcs(X, Y, n, m-1))
    return dp[n][m]

if __name__ == '__main__':
    X, Y = input().split()
    n, m = len(X), len(Y)
    print(lcs(X, Y, n, m))
