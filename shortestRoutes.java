import java.util.*;

class Main {
    static final long INF = 1000000000000000L;

    public static void dijkstra(int N, List<Pair<Integer, Integer>>[] adj) {
        long[] distance = new long[N];
        Arrays.fill(distance, INF);

        distance[0] = 0;

        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingLong(Pair::getFirst));

        pq.add(new Pair<>(0, 0));

        while (!pq.isEmpty()) {
            int dist = pq.peek().getFirst();
            int node = pq.peek().getSecond();

            pq.poll();

            if (dist > distance[node])
                continue;

            for (Pair<Integer, Integer> neighbor : adj[node]) {
                int to = neighbor.getSecond();
                int weight = neighbor.getFirst();

                if (distance[to] > dist + weight) {
                    distance[to] = dist + weight;
                    pq.add(new Pair<>(distance[to], to));
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(distance[i] + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        List<Pair<Integer, Integer>>[] adj = new List[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            a--;
            b--;
            adj[a].add(new Pair<>(c, b));
        }

        dijkstra(N, adj);
    }
}

class Pair<F, S> {
    private F first;
    private S second;

    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    public F getFirst() {
        return first;
    }

    public S getSecond() {
        return second;
    }
}
