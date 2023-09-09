import sys
from collections import deque

def init():
    # fast_io
    # Remove the following two lines if not needed
    # (Python does not require these for input and output)
    # sys.stdin = open("input.txt", "r")
    # sys.stdout = open("output.txt", "w")

def bfs(node, n, adj):
    q = deque()
    q.append((node, 0))
    
    vis = [False] * (n + 1)
    vis[node] = True
    
    lastVis = None
    
    while q:
        lastVis = q.popleft()
        
        for child in adj[lastVis[0]]:
            if not vis[child]:
                q.append((child, lastVis[1] + 1))
                vis[child] = True
    
    return lastVis

def main():
    init()
    
    n = int(input())
    
    adj = [[] for _ in range(n + 1)]
    
    for i in range(1, n):
        a, b = map(int, input().split())
        adj[a].append(b)
        adj[b].append(a)
    
    p = bfs(1, n, adj)
    pp = bfs(p[0], n, adj)
    
    print(pp[1])

if __name__ == "__main__":
    main()
