import java.util.ArrayList;
import java.util.List;

class Solution {

    public boolean dfs(int node, int color, int[] vis, List<List<Integer>> graph) {
        vis[node] = color;
        for (int child : graph.get(node)) {
            if (vis[child] == -1) {
                boolean check = dfs(child, 1 - color, vis, graph);
                if (!check) return false;
            } else {
                if (vis[child] == vis[node])
                    return false;
            }
        }
        return true;
    }

    public boolean isBipartite(List<List<Integer>> graph) {
        int n = graph.size();
        int[] vis = new int[n];
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                boolean check = dfs(i, 0, vis, graph);
                if (!check) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // You can test your code here if needed.
    }
}
