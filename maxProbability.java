import java.util.*;

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        double ans = 0;
        PriorityQueue<Pair<Double, Integer>> q = new PriorityQueue<>(Collections.reverseOrder());
        q.offer(new Pair<>(1.0, start));
        List<Pair<Integer, Double>>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double w = succProb[i];
            adj[u].add(new Pair<>(v, w));
            adj[v].add(new Pair<>(u, w));
        }
        double[] probability = new double[n];
        probability[start] = 1;
        while (!q.isEmpty()) {
            int pos = q.peek().getValue();
            double cnt = q.poll().getKey();
            if (pos == end) {
                ans = Math.max(ans, cnt);
            }
            for (Pair<Integer, Double> it : adj[pos]) {
                int neighbor = it.getKey();
                double weight = it.getValue();
                if (cnt * weight > probability[neighbor]) {
                    probability[neighbor] = cnt * weight;
                    q.offer(new Pair<>(probability[neighbor], neighbor));
                }
            }
        }
        return ans;
    }
}

