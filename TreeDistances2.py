import sys

def dfs(par, node, depth, adj, dp, ans):
    ans[1] += depth

    for child in adj[node]:
        if child != par:
            dfs(node, child, depth + 1, adj, dp, ans)
            dp[node] += dp[child]

def dfs2(par, node, n, adj, dp, ans):
    for child in adj[node]:
        if child != par:
            ans[child] = ans[node] + (n - 2 * (dp[child]))
            dfs2(node, child, n, adj, dp, ans)

def main():
    n = int(input())

    adj = [[] for _ in range(n + 1)]

    for i in range(1, n):
        a, b = map(int, input().split())
        adj[a].append(b)
        adj[b].append(a)

    dp = [1] * (n + 1)
    ans = [0] * (n + 1)

    dfs(0, 1, 0, adj, dp, ans)
    dfs2(0, 1, n, adj, dp, ans)

    for i in range(1, n + 1):
        print(ans[i], end=" ")

if __name__ == "__main__":
    main()
