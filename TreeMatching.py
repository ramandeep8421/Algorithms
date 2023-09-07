import sys

sys.setrecursionlimit(200005)

ans = 0
MAX = 200005

done = [False] * MAX

def dfs(pre, node, adj):
    global ans
    for child in adj[node]:
        if child != pre:
            dfs(node, child, adj)
            if not done[child] and not done[node]:
                done[child] = done[node] = True
                ans += 1

def main():
    n = int(input())
    adj = [[] for _ in range(n + 1)]

    for i in range(1, n):
        a, b = map(int, input().split())
        adj[a].append(b)
        adj[b].append(a)

    global ans
    ans = 0
    dfs(0, 1, adj)

    print(ans)

if __name__ == "__main__":
    main()
