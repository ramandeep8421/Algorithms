dp = [[-1 for i in range(1001)] for j in range(1001)]

def rodCutting(index, n, price):
    # Base case
    if index == 0:
        return n * price[index]

    # If the result for the pair (index, n)
    # is already memoized then return the result
    if dp[index][n] != -1:
        return dp[index][n]

    # case-1: do not make at at index
    doNotCut = rodCutting(index - 1, n, price)

    # Case-2: Make a cut at index
    cut = float('-inf')

    # Length of the rod
    rod_length = index + 1

    # If the length of the rod is
    # less than the remaining size
    # of the rod
    if rod_length <= n:
        cut = price[index] + rodCutting(index - 1, n - rod_length, price)

    # Memoize the result for that particular (index, n) pair
    dp[index][n] = max(cut, doNotCut)
    return dp[index][n]


n = int(input())
price = list(map(int, input().split()))

for i in range(1001):
    for j in range(1001):
        dp[i][j] = -1

print(rodCutting(n - 1, n, price))
