import sys
sys.stdin = open("input.txt", "r")
sys.stdout = open("output.txt", "w")

MAXN = 200011
adj = [[] for _ in range(MAXN)]
sub = [1] * MAXN
n = 0
t = [0] * (4 * MAXN)
timer = 0
start = [0] * MAXN
value = [0] * MAXN
arr = [0] * MAXN

def build(v, tl, tr):
    if tl == tr:
        t[v] = arr[tl]
        return
    tm = (tl + tr) // 2
    build(v * 2, tl, tm)
    build(v * 2 + 1, tm + 1, tr)
    t[v] = t[v * 2] + t[v * 2 + 1]

def update(v, tl, tr, pos, new_val):
    if tl == tr:
        t[v] = new_val
    else:
        tm = (tl + tr) // 2
        if pos <= tm:
            update(v * 2, tl, tm, pos, new_val)
        else:
            update(v * 2 + 1, tm + 1, tr, pos, new_val)
        t[v] = t[v * 2] + t[v * 2 + 1]

def sum(v, tl, tr, l, r):
    if l > r:
        return 0
    if l == tl and r == tr:
        return t[v]
    tm = (tl + tr) // 2
    return sum(v * 2, tl, tm, l, min(r, tm)) + sum(v * 2 + 1, tm + 1, tr, max(l, tm + 1), r)

def dfs(node, par):
    global timer
    timer += 1
    start[node] = timer
    arr[start[node]] = value[node]
    for child in adj[node]:
        if child != par:
            dfs(child, node)
            sub[node] += sub[child]

def solve():
    global n
    global sub
    n, q = map(int, input().split())
    for i in range(1, n + 1):
        value[i] = int(input())

    for i in range(1, n):
        a, b = map(int, input().split())
        adj[a].append(b)
        adj[b].append(a)

    dfs(1, -1)

    build(1, 1, n)

    while q > 0:
        t = int(input())
        if t == 1:
            s, x = map(int, input().split())
            update(1, 1, n, start[s], x)
            arr[start[s]] = x
        else:
            s = int(input())
            print(sum(1, 1, n, start[s], start[s] + sub[s] - 1))
        q -= 1

def main():
    init()
    t = 1
    # t = int(input())
    while t > 0:
        solve()
        t -= 1

if __name__ == "__main__":
    main()
