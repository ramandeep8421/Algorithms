def edit_distance(X, Y, m, n, dp):
    # If the first string is exhausted then append all characters of the second string
    if m == 0:
        dp[m][n] = n
        return dp[m][n]

    # If the second string is exhausted then append all characters of the first string
    if n == 0:
        dp[m][n] = m
        return dp[m][n]

    # In case the result is already computed
    if dp[m][n] != -1:
        return dp[m][n]

    # If the last characters match, then move to the right by one
    if X[m-1] == Y[n-1]:
        dp[m][n] = edit_distance(X, Y, m-1, n-1, dp)

    # Otherwise explore all three cases and take the minimum of the three
    else:
        dp[m][n] = 1 + min(edit_distance(X, Y, m, n-1, dp),  # Insert
                           edit_distance(X, Y, m-1, n, dp),  # Delete
                           edit_distance(X, Y, m-1, n-1, dp) # Replace
                           )
    return dp[m][n]


def main():
    X, Y = input().split()
    dp = [[-1 for _ in range(500)] for _ in range(500)]
    print(edit_distance(X, Y, len(X), len(Y), dp))


if __name__ == "__main__":
    main()
