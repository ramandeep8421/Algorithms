import sys

MAXN = 200011
M = 20

up = [[0 for _ in range(M)] for _ in range(MAXN)]
level = [0] * MAXN

def dfs(node, par, adj, lvl):
    up[node][0] = par
    level[node] = lvl

    for child in adj[node]:
        if child != par:
            dfs(child, node, adj, lvl + 1)

def preprocess():
    for i in range(1, MAXN):
        for j in range(1, M):
            if up[i][j - 1] != -1:
                par = up[i][j - 1]
                up[i][j] = up[par][j - 1]

def main():
    # Uncomment the following lines if you want to redirect stdin and stdout
    # to input.txt and output.txt respectively.
    # if not sys.stdin.isatty():
    #     sys.stdin = open("input.txt", "r")
    # if not sys.stdout.isatty():
    #     sys.stdout = open("output.txt", "w")

    n, q = map(int, input().split())
    
    adj = [[] for _ in range(n + 1)]

    for i in range(2, n + 1):
        a = int(input())
        adj[i].append(a)
        adj[a].append(i)

    dfs(1, -1, adj, 0)
    preprocess()

    for _ in range(q):
        x, k = map(int, input().split())

        if level[x] < k:
            print(-1)
            continue

        while k:
            i = (k & -k).bit_length() - 1
            x = up[x][i]
            if x == -1:
                break
            k -= 1 << i

        print(x)

if __name__ == "__main__":
    main()
