import java.util.*;

class Main {
    static final long INF = Long.MAX_VALUE;

    static class Pair {
        int node;
        long cost;

        Pair(int node, long cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    static long[] dijkstra(int src, int N, List<Pair>[] adj) {
        long[] distance = new long[N + 1];
        Arrays.fill(distance, INF);

        distance[src] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingLong(p -> p.cost));
        pq.offer(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair p = pq.poll();

            int node = p.node;
            long cost = p.cost;

            if (distance[node] < cost) continue;

            for (Pair neighbor : adj[node]) {
                int to = neighbor.node;
                long c = neighbor.cost;

                if (distance[to] > c + distance[node]) {
                    distance[to] = c + distance[node];
                    pq.offer(new Pair(to, distance[to]));
                }
            }
        }

        return distance;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<Pair>[] adj = new ArrayList[n + 1];
        List<Pair>[] adjRev = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
            adjRev[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();

            adj[a].add(new Pair(b, c));
            adjRev[b].add(new Pair(a, c));
        }

        long[] minCosts = dijkstra(1, n, adj);
        long[] minCostsRev = dijkstra(n, n, adjRev);

        long ans = INF;

        for (int i = 1; i <= n; i++) {
            for (Pair neighbor : adj[i]) {
                int to = neighbor.node;
                long c = neighbor.cost;

                if (minCosts[i] == INF || minCostsRev[to] == INF) continue;

                ans = Math.min(ans, minCosts[i] + c / 2 + minCostsRev[to]);
            }
        }

        System.out.println(ans);
    }
}
