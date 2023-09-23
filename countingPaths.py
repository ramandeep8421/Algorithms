import sys

def init():
    # Uncomment the following lines to read from an input file and write to an output file
    # sys.stdin = open('input.txt', 'r')
    # sys.stdout = open('output.txt', 'w')
    pass

maxN = 200001
logN = 20

N, M, a, b = 0, 0, 0, 0
sub = [0] * maxN
p = [[0] * logN for _ in range(maxN)]
timer = 0
in_ = [0] * maxN
out = [0] * maxN
G = [[] for _ in range(maxN)]

def dfs1(u=1, par=1):
    global timer
    in_[u] = timer + 1
    timer += 1
    p[u][0] = par
    for i in range(1, logN):
        p[u][i] = p[p[u][i - 1]][i - 1]
    for v in G[u]:
        if v != par:
            dfs1(v, u)
    out[u] = timer + 1
    timer += 1

def dfs2(u=1):
    for v in G[u]:
        if v != p[u][0]:
            dfs2(v)
            sub[u] += sub[v]

def ancestor(u, v):
    return in_[u] <= in_[v] and out[u] >= out[v]

def lca(u, v):
    if ancestor(u, v):
        return u
    if ancestor(v, u):
        return v
    for i in range(logN - 1, -1, -1):
        if not ancestor(p[u][i], v):
            u = p[u][i]
    return p[u][0]

def solve():
    global N, M, a, b
    n, m = map(int, input().split())
    N = n
    M = m

    for i in range(1, n):
        a, b = map(int, input().split())
        G[a].append(b)
        G[b].append(a)

    dfs1()

    for i in range(m):
        a, b = map(int, input().split())
        l = lca(a, b)
        sub[a] += 1
        sub[b] += 1
        sub[l] -= 1
        if l != -1:
            sub[p[l][0]] -= 1

    dfs2(1)

    for i in range(1, n + 1):
        print(sub[i], end=" ")

if __name__ == "__main__":
    init()
    t = 1
    # t = int(input())
    while t > 0:
        solve()
        t -= 1
