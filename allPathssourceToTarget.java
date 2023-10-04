import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int target = graph.length - 1;
        int source = 0;
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        dfs(graph, source, target, path, ans);
        return ans;
    }

    private void dfs(int[][] graph, int source, int target, List<Integer> path, List<List<Integer>> ans) {
        if (source == target) {
            path.add(source);
            ans.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }

        path.add(source);

        for (int neighbor : graph[source]) {
            dfs(graph, neighbor, target, path, ans);
        }

        path.remove(path.size() - 1);
    }
}
