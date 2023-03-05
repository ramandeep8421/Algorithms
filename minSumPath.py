def coinChange(idx, coins, amount):
    # If the number of coins are exhausted
    if idx >= len(coins) or amount <= 0:
        return 0

    res = -1
    # If the value of coin at current location
    # is greater than amount
    if coins[idx] > amount:
        # Case where we are not taking the current coin
        doNotTakeCoin = coinChange(idx+1, coins, amount)
        res = doNotTakeCoin
    else:
        # Two cases are there
        # case-1: where we take the coin
        # case-2: where we do not take the coin
        takeCoin = 1 + coinChange(idx, coins, amount-coins[idx])
        doNotTakeCoin = 0 + coinChange(idx+1, coins, amount)
        res = min(takeCoin, doNotTakeCoin)

    return res

if __name__ == "__main__":
    n, amount = map(int, input().split())
    coins = list(map(int, input().split()))
    print(coinChange(0, coins, amount))
