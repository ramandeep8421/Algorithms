from typing import List
import queue


class Solution:
    def __init__(self):
        # Adjacency list, defined it as per the maximum number of nodes
        # But can be defined with the input size as well
        self.adj = [[] for _ in range(101)]

    def BFS(self, signalReceivedAt: List[int], k: int) -> None:
        qu = queue.Queue()
        qu.put(k)

        signalReceivedAt[k] = 0

        while not qu.empty():

            currNode = qu.get()

            for time, neighbourNode in self.adj[currNode]:
                arrivalTime = signalReceivedAt[currNode] + time

                if signalReceivedAt[neighbourNode] > arrivalTime:
                    signalReceivedAt[neighbourNode] = arrivalTime
                    qu.put(neighbourNode)

    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        # Build the adjacency list
        for time in times:
            source, dest, travelTime = time

            self.adj[source].append((travelTime, dest))

        signalReceivedAt = [float('inf')] * (n + 1)

        self.BFS(signalReceivedAt, k)

        answer = float('-inf')
        for node in range(1, n + 1):
            answer = max(answer, signalReceivedAt[node])

        # float('inf') signifies at least one node is unreachable
        return -1 if answer == float('inf') else answer
