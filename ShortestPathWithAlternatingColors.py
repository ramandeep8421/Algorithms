from typing import List
from collections import deque

class Solution:
    def shortestAlternatingPaths(self, n: int, redEdges: List[List[int]], blueEdges: List[List[int]]) -> List[int]:
        
        # adjacency list to represent the given graph
        adj = [[] for _ in range(n)]
        
        # red edges are represented by 0
        for redEdge in redEdges:
            adj[redEdge[0]].append((redEdge[1], 0))
        
        # blue edges are represented by 1
        for blueEdge in blueEdges:
            adj[blueEdge[0]].append((blueEdge[1], 1))
         
        # declare an answer array
        answer = [-1] * n

        # declare the visited array
        visited = [[False]*2 for _ in range(n)]

        # declare an empty queue
        q = deque()

        # insert the first tuple 
        # starting with node 0, with number of steps as 0 and undefined color -1
        q.append((0, 0, -1))

        # initialize the visited array
        visited[0][1] = visited[0][0] = True

        # initialize the answer array
        answer[0] = 0

        while q:
            node, steps, prevColor = q.popleft()

            for neighbor, color in adj[node]:
                if not visited[neighbor][color] and color != prevColor:
                    visited[neighbor][color] = True
                    q.append((neighbor, 1 + steps, color))
                    if answer[neighbor] == -1:
                        answer[neighbor] = 1 + steps

        return answer
