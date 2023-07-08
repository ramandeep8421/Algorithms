import sys
from typing import List, Tuple

sys.setrecursionlimit(10**6)

adj = [[] for _ in range(100005)]
vis = [False] * 100005
v = []
v1 = [0] * 100005

def dfs(s: int) -> None:
    if vis[s]:
        return
    vis[s] = True
    for i in adj[s]:
        dfs(i)
    v.append(s)

def cycle(s: int) -> bool:
    v1[s] = 1
    for i in adj[s]:
        if not v1[i]:
            if cycle(i):
                return True
        elif v1[i] == 1:
            return True
    v1[s] = 2
    return False

def solve() -> None:
    n, m = map(int, input().split())
    for _ in range(m):
        a, b = map(int, input().split())
        adj[b].append(a)
    for i in range(1, n + 1):
        if not v1[i] and cycle(i):
            print("IMPOSSIBLE")
            return
        if not vis[i]:
            dfs(i)
    print(*v[::-1])

if __name__ == "__main__":
    # Uncomment the following two lines if input/output is to be taken from/to files
    # sys.stdin = open('input.txt', 'r')
    # sys.stdout = open('output.txt', 'w')
    t = 1
    # t = int(input())
    while t > 0:
        solve()
        t -= 1
    # Uncomment the following code if the execution time needs to be measured
    # import time
    # start = time.time()
    # print(f"\nTime Taken: {time.time() - start:.10f} seconds")
