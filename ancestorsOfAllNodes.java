import java.util.ArrayList;
import java.util.List;

public class Solution {
    public void dfs(int x, int curr, List<List<Integer>> ans, List<List<Integer>> graph) {
        for (int it : graph.get(curr)) {
            if (graph.get(it).size() == 0 || graph.get(it).get(graph.get(it).size() - 1) != x) {
                ans.get(it).add(x);
                dfs(x, it, ans, graph);
            }
        }
    }

    public List<List<Integer>> getAncestor(int n, List<List<Integer>> edges) {
        List<List<Integer>> graph = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            ans.add(new ArrayList<>());
        }

        for (List<Integer> it : edges) {
            graph.get(it.get(0)).add(it.get(1));
        }

        for (int i = 0; i < n; i++) {
            dfs(i, i, ans, graph);
        }

        return ans;
    }
}
