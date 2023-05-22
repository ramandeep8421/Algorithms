import java.util.ArrayList;
import java.util.List;

class Solution {
    double prob = 0;
    int target;
    List<List<Integer>> adjList;
    List<Integer> visited;

    double dfs(int i, int t) {
        if (i != 1 && adjList.get(i).size() == 1 || t == 0) {
            return i == target ? 1 : 0;
        }

        visited.set(i, 1);

        double res = 0;

        for (int j : adjList.get(i)) {
            if (visited.get(j) == 0) {
                res += dfs(j, t - 1);
            }
        }

        return res / (adjList.get(i).size() - (i != 1 ? 1 : 0));
    }

    double frogPosition(int n, List<List<Integer>> edges, int t, int target) {
        adjList = new ArrayList<>(n + 1);
        visited = new ArrayList<>(n + 1);

        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
            visited.add(0);
        }

        this.target = target;

        for (List<Integer> u : edges) {
            int from = u.get(0);
            int to = u.get(1);
            adjList.get(from).add(to);
            adjList.get(to).add(from);
        }

        return dfs(1, t);
    }
}


