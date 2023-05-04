from typing import List
import queue

class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        # adjacency list to store the graph
        adj = [[] for _ in range(n)]
        
        # generate the list from the given set of flights
        for u, v, w in flights:
            adj[u].append((v, w))
        
        # declare a distance array
        distance = [float('inf') for _ in range(n)]
        
        # declare a queue
        qu = queue.Queue()
        
        # initialize it with the source vertex
        qu.put((src, 0))
        
        # initialize the stops to zero
        stops = 0
        
        # here the pair represents the vertex and its 
        # distance from the source vertex
        while stops <= k and not qu.empty():
            # calculate the size of the queue
            size = qu.qsize()
            
            while size > 0:
                # pop the front pair 
                node = qu.get()
                
                # vertex
                u = node[0]
                
                # distance of the node from vertex
                dist = node[1]
                
                # move to the adjacent nodes
                for neighbor, price in adj[u]:
                    if distance[neighbor] > dist + price:
                        distance[neighbor] = dist + price
                        qu.put((neighbor, distance[neighbor]))
                
                size -= 1
            stops += 1
        
        return -1 if distance[dst] == float('inf') else distance[dst]
