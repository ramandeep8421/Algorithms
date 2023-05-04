import java.util.*;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // adjacency list to store the graph
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        // generate the list from the given set of flights
        for (int[] flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int w = flight[2];
            adj.get(u).add(new int[]{v, w});
        }
        
        // declare a distance array
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        
        // declare a queue
        Queue<int[]> queue = new LinkedList<>();
        
        // initialize it with the source vertex
        queue.add(new int[]{src, 0});
        
        // initialize the stops to zero
        int stops = 0;
        
        // here the array represents the vertex and its 
        // distance from the source vertex
        while (stops <= k && !queue.isEmpty()) {
            // calculate the size of the queue
            int size = queue.size();
            
            while (size-- > 0) {
                // pop the front array 
                int[] node = queue.poll();
                
                // vertex
                int u = node[0];
                
                // distance of the node from vertex
                int dist = node[1];
                
                // move to the adjacent nodes
                for (int[] edge : adj.get(u)) {
                    int v = edge[0];
                    int w = edge[1];
                    
                    if (distance[v] > dist + w) {
                        distance[v] = dist + w;
                        queue.add(new int[]{v, distance[v]});
                    }
                }
            }
            stops++;
        }
        
        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
    }
}
