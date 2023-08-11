import java.util.*;

public class Solution {
    int ans = Integer.MAX_VALUE;

    void bfs(int node, List<Integer>[] adj, boolean[] vis, int[] dis) {
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(node, -1));
        vis[node] = true;
        dis[node] = 0;

        while (!q.isEmpty()) {
            int currentNode = q.peek().getKey();
            int parent = q.peek().getValue();
            q.poll();

            for (int it : adj[currentNode]) {
                if (!vis[it]) {
                    dis[it] = dis[currentNode] + 1;
                    q.add(new Pair<>(it, currentNode));
                    vis[it] = true;
                } else if (it != parent) {
                    ans = Math.min(ans, dis[it] + dis[currentNode] + 1);
                }
            }
        }
    }

    int findShortestCycle(int n, int[][] edges) {
        List<Integer>[] adj = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] it : edges) {
            adj[it[0]].add(it[1]);
            adj[it[1]].add(it[0]);
        }

        for (int i = 0; i < n; i++) {
            boolean[] vis = new boolean[n + 1];
            int[] dis = new int[n + 1];
            Arrays.fill(dis, 1_000_000_000);

            bfs(i, adj, vis, dis);
        }

        if (ans == Integer.MAX_VALUE) return -1;

        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 4;
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}, {2, 3}, {3, 0}};
        System.out.println(solution.findShortestCycle(n, edges)); // Output: 4
    }
}
