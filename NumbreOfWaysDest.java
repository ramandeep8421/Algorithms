import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {

    public int countPaths(int n, int[][] roads) {
        long MOD = 1000000007;
        long[] distance = new long[n];
        Arrays.fill(distance, Long.MAX_VALUE);
        long[] ways = new long[n];

        distance[0] = 0;
        List<int[]>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] it : roads) {
            adj[it[0]].add(new int[]{it[1], it[2]});
            adj[it[1]].add(new int[]{it[0], it[2]});
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.add(new long[]{0, 0});
        ways[0] = 1;

        while (!pq.isEmpty()) {
            long[] p = pq.poll();

            int node = (int) p[1];
            long dist = p[0];

            if (distance[node] < dist) {
                continue;
            }

            for (int[] it : adj[node]) {
                int to = it[0];
                int wt = it[1];

                if (distance[to] > dist + wt) {
                    distance[to] = dist + wt;
                    ways[to] = ways[node];
                    pq.add(new long[]{distance[to], to});
                } else if (distance[to] == dist + wt) {
                    ways[to] = (ways[to] + ways[node]) % MOD;
                }
            }
        }

        return (int) (ways[n - 1] % MOD);
    }
}
