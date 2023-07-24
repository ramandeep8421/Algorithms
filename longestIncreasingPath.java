import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public List<Integer> kahnAlgorithm(int n, int m, List<Integer>[] adj, int[] indegree) {
        List<Integer> order = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n * m; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            order.add(node);

            for (int neighbor : adj[node]) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        return order;
    }

    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        List<Integer>[] adj = new ArrayList[n * m];
        int[] indegree = new int[n * m];

        int[] dir = {0, -1, 0, 1, 0};

        for (int i = 0; i < n * m; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 4; k++) {
                    int x = i + dir[k];
                    int y = j + dir[k + 1];

                    if (x >= 0 && y >= 0 && x < n && y < m && matrix[x][y] > matrix[i][j]) {
                        adj[i * m + j].add(x * m + y);
                        indegree[x * m + y]++;
                    }
                }
            }
        }

        List<Integer> order = kahnAlgorithm(n, m, adj, indegree);

        int[] dp = new int[n * m];
        Arrays.fill(dp, 1);

        for (int it : order) {
            for (int edge : adj[it]) {
                dp[edge] = Math.max(dp[edge], dp[it] + 1);
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }
}
