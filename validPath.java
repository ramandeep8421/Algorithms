import java.util.*;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        boolean[] seen = new boolean[n];
        seen[source] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            if (node == destination) {
                return true;
            }

            for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                if (!seen[neighbor]) {
                    seen[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }

        return false;
    }
}
