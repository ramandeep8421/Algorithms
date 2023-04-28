import java.util.*;

class Solution {
    // Adjacency list, defined it as per the maximum number of nodes
    // But can be defined with the input size as well
    List<List<int[]>> adj = new ArrayList<>();

    public void DFS(int[] signalReceivedAt, int currNode, int currTime) {

        // If the current time is greater than or equal to the fastest signal received
        // Then no need to iterate over adjacent nodes
        if (currTime >= signalReceivedAt[currNode]) {
            return;
        }

        // Fastest signal time for currNode so far
        signalReceivedAt[currNode] = currTime;

        // Broadcast the signal to adjacent nodes
        for (int[] edge : adj.get(currNode)) {
            int travelTime = edge[0];
            int neighborNode = edge[1];

            // currTime + time : time when signal reaches neighborNode
            DFS(signalReceivedAt, neighborNode, currTime + travelTime);
        }

    }

    public int networkDelayTime(int[][] times, int n, int k) {
        // Initialize the adjacency list
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<int[]>());
        }

        // Build the adjacency list
        for (int[] time : times) {
            int source = time[0];
            int dest = time[1];
            int travelTime = time[2];

            adj.get(source).add(new int[]{travelTime, dest});
        }

        // Sort the edges connecting to every node
        for (int i = 1; i <= n; i++) {
            Collections.sort(adj.get(i), (a, b) -> a[0] - b[0]);
        }

        int[] signalReceivedAt = new int[n + 1];
        Arrays.fill(signalReceivedAt, Integer.MAX_VALUE);

        DFS(signalReceivedAt, k, 0);

        int answer = Integer.MIN_VALUE;
        for (int node = 1; node <= n; node++) {
            answer = Math.max(answer, signalReceivedAt[node]);
        }

        // INT_MAX signifies at least one node is unreachable
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}

      

      
     
      

      


      
      
      
