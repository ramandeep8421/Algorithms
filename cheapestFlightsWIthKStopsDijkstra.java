import java.util.*;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // adjacency list for storing the graph
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // prepare the adjacency list
        for (int[] e : flights) {
            adj.get(e[0]).add(new int[]{e[1], e[2]});
        }

        // stops array to count the number
        int[] stops = new int[n];
        Arrays.fill(stops, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, src, 0});

        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            int dist = temp[0];
            int node = temp[1];
            int steps = temp[2];

            if (steps > stops[node] || steps > k + 1) continue;
            stops[node] = steps;

            if (node == dst) return dist;

            for (int[] neighbor : adj.get(node)) {
                pq.offer(new int[]{dist + neighbor[1], neighbor[0], steps + 1});
            }
        }

        return -1;
    }
}

 

            


           
