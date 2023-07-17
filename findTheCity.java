import java.util.*;

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<Pair<Integer, Integer>>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            adj.get(u).add(new Pair<>(v, wt));
            adj.get(v).add(new Pair<>(u, wt));
        }

        int cnt = (int) 1e9;
        int city = -1;

        for (int k = 0; k < n; k++) {
            int[] distance = new int[n];
            Arrays.fill(distance, (int) 1e9);

            PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Pair::getKey));
            pq.offer(new Pair<>(0, k));
            distance[k] = 0;

            while (!pq.isEmpty()) {
                Pair<Integer, Integer> p = pq.poll();
                int node = p.getValue();
                int cost = p.getKey();

                if (distance[node] < cost) continue;

                for (Pair<Integer, Integer> neighbor : adj.get(node)) {
                    int to = neighbor.getKey();
                    int wt = neighbor.getValue();

                    if (distance[to] > distance[node] + wt) {
                        distance[to] = distance[node] + wt;
                        pq.offer(new Pair<>(distance[to], to));
                    }
                }
            }

            int count = 0;

            for (int it : distance) {
                if (it <= distanceThreshold) count++;
            }

            if (count <= cnt) {
                cnt = count;
                city = k;
            }
        }

        return city;
    }
}
