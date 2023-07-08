from typing import List


def dfs_cycle(node: int, adj: List[List[int]], vis: List[int], stack_rec: List[int]) -> bool:
    vis[node] = 1
    stack_rec[node] = 1
    
    for neighbor in adj[node]:
        if vis[neighbor] == 0:
            if dfs_cycle(neighbor, adj, vis, stack_rec):
                return True
        elif stack_rec[neighbor] == 1:
            return True
    
    stack_rec[node] = 0
    
    return False


def is_cycle(N: int, adj: List[List[int]]) -> bool:
    vis = [0] * N
    stack_rec = [0] * N
    
    for i in range(N):
        if vis[i] == 0:
            if dfs_cycle(i, adj, vis, stack_rec):
                return True
    
    return False
