MOD = int(1e9) + 7

def main():
    n = int(input())
    board = [input().strip() for _ in range(n)]

    if board[0][0] == '*' or board[n - 1][n - 1] == '*':
        print(0)
        return

    dp = [[0] * n for _ in range(n)]
    dp[0][0] = 1

    for i in range(n):
        for j in range(n):
            if i - 1 >= 0 and board[i][j] != '*':
                dp[i][j] += dp[i - 1][j]
                dp[i][j] %= MOD
            if j - 1 >= 0 and board[i][j] != '*':
                dp[i][j] += dp[i][j - 1]
                dp[i][j] %= MOD

    print(dp[n - 1][n - 1])

if __name__ == "__main__":
    main()
