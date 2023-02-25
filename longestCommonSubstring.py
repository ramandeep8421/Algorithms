def lcs(X, Y, m, n):
    dp = [[0] * (n + 1) for _ in range(m + 1)]
    result = 0

    for i in range(m + 1):
        for j in range(n + 1):
            if i == 0 or j == 0:
                dp[i][j] = 0
            elif X[i - 1] == Y[j - 1]:
                dp[i % 2][j] = dp[(i - 1) % 2][j - 1] + 1
                result = max(result, dp[i % 2][j])
            else:
                dp[i % 2][j] = 0

    print(result)


if __name__ == '__main__':
    x, y = input().split()
    lcs(x, y, len(x), len(y))
