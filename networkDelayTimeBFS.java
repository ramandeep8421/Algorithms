import java.util.*;

class Solution {

    // Adjacency list, defined it as per the maximum number of nodes
    // But can be defined with the input size as well
    List<List<int[]>> adj = new ArrayList<>(101);

    public void BFS(int[] signalReceivedAt, int k) {
        Queue<Integer> qu = new LinkedList<>();
        qu.offer(k);

        signalReceivedAt[k] = 0;

        while (!qu.isEmpty()) {
            int currNode = qu.poll();

            for (int[] edge : adj.get(currNode)) {
                int time = edge[0];
                int neighbourNode = edge[1];

                int arrivalTime = signalReceivedAt[currNode] + time;

                if (signalReceivedAt[neighbourNode] > arrivalTime) {
                    signalReceivedAt[neighbourNode] = arrivalTime;
                    qu.offer(neighbourNode);
                }
            }
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        // Build the adjacency list
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] time : times) {
            int source = time[0];
            int dest = time[1];
            int travelTime = time[2];

            adj.get(source).add(new int[]{travelTime, dest});
        }

        int[] signalReceivedAt = new int[n + 1];
        Arrays.fill(signalReceivedAt, Integer.MAX_VALUE);

        BFS(signalReceivedAt, k);

        int answer = Integer.MIN_VALUE;
        for (int node = 1; node <= n; node++) {
            answer = Math.max(answer, signalReceivedAt[node]);
        }

        // INT_MAX signifies at least one node is unreachable
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

}
