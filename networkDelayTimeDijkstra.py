import heapq
from typing import List, Tuple

class Solution:
    def __init__(self):
        # Adjacency list, defined it as per the maximum number of nodes
        # But can be defined with the input size as well
        self.adj = [[] for _ in range(101)]
        
    def dijkstra(self, signalReceivedAt: List[int], source: int, n: int) -> None:
        pq = [(0, source)]
        heapq.heapify(pq)
        
        # Time for starting node is 0
        signalReceivedAt[source] = 0
        
        while pq:
            currNodeTime, currNode = heapq.heappop(pq)
            
            if currNodeTime > signalReceivedAt[currNode]:
                continue
            
            # Broadcast the signal to adjacent nodes
            for time, neighborNode in self.adj[currNode]:
                # Fastest signal time for neighborNode so far
                # signalReceivedAt[currNode] + time : 
                # time when signal reaches neighborNode
                if signalReceivedAt[neighborNode] > currNodeTime + time:
                    signalReceivedAt[neighborNode] = currNodeTime + time
                    heapq.heappush(pq, (signalReceivedAt[neighborNode], neighborNode))
        
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        # Build the adjacency list
        for source, dest, travelTime in times:
            self.adj[source].append((travelTime, dest))
        
        signalReceivedAt = [float('inf')] * (n + 1)
        self.dijkstra(signalReceivedAt, k, n)
        
        answer = max(signalReceivedAt[1:])
        
        # float('inf') signifies at least one node is unreachable
        return -1 if answer == float('inf') else answer
