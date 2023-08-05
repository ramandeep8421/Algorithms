import java.util.*;

public class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        int[] inDegree = new int[n];
        for (int[] rel : relations) {
            int prev = rel[0] - 1;
            int next = rel[1] - 1;
            adj[prev].add(next);
            inDegree[next]++;
        }

        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[n];

        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
                dist[i] = time[i];
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int neighbor : adj[node]) {
                inDegree[neighbor]--;
                dist[neighbor] = Math.max(dist[neighbor], dist[node] + time[neighbor]);
                if (inDegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        int maxTime = Integer.MIN_VALUE;
        for (int d : dist) {
            maxTime = Math.max(maxTime, d);
        }

        return maxTime;
    }
}
