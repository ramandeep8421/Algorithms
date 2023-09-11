import queue

def bfs(node, n, adj):
    q = queue.Queue()
    q.put((node, 0))
    
    vis = [False] * (n + 1)
    vis[node] = True
    
    u = (0, 0)
    
    while not q.empty():
        u = q.get()
        
        for child in adj[u[0]]:
            if not vis[child]:
                q.put((child, u[1] + 1))
                vis[child] = True
                
    return u

def dfs(par, node, d, c, adj, dp):
    dp[node][c] = d
    
    for child in adj[node]:
        if child != par:
            dfs(node, child, d + 1, c, adj, dp)

def main():
    n = int(input())
    
    adj = [[] for _ in range(n + 1)]
    
    for i in range(1, n):
        a, b = map(int, input().split())
        adj[a].append(b)
        adj[b].append(a)
    
    p = bfs(1, n, adj)
    
    pp = bfs(p[0], n, adj)
    
    dp = [[0] * 2 for _ in range(n + 1)]
    
    dfs(0, p[0], 0, 0, adj, dp)
    
    dfs(0, pp[0], 0, 1, adj, dp)
    
    for i in range(1, n + 1):
        print(max(dp[i][0], dp[i][1]), end=" ")

if __name__ == "__main__":
    main()
