from typing import List, Tuple
import sys


class Solution:
    def __init__(self):
        # Adjacency list, defined it as per the maximum number of nodes
        # But can be defined with the input size as well
        self.adj = [[] for _ in range(101)]

    def DFS(self, signalReceivedAt: List[int], currNode: int, currTime: int) -> None:
        # If the current time is greater than or equal to the fastest signal received
        # Then no need to iterate over adjacent nodes
        if currTime >= signalReceivedAt[currNode]:
            return

        # Fastest signal time for currNode so far
        signalReceivedAt[currNode] = currTime

        # Broadcast the signal to adjacent nodes
        for travelTime, neighborNode in self.adj[currNode]:
            # currTime + time : time when signal reaches neighborNode
            self.DFS(signalReceivedAt, neighborNode, currTime + travelTime)

    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        # Build the adjacency list
        for source, dest, travelTime in times:
            self.adj[source].append((travelTime, dest))

        # Sort the edges connecting to every node
        for i in range(1, n + 1):
            self.adj[i].sort()

        signalReceivedAt = [sys.maxsize] * (n + 1)

        self.DFS(signalReceivedAt, k, 0)

        answer = max(signalReceivedAt[1:])

        # sys.maxsize signifies at least one node is unreachable
        return -1 if answer == sys.maxsize else answer
