import java.util.*;

class Solution {
    public int[] dijkstra(int V, List<int[][]> adj, int S) {
        int INF = 1_000_000_000;
        int[] distance = new int[V + 1];
        Arrays.fill(distance, INF);

        distance[S] = 0;

        TreeSet<Pair<Integer, Integer>> st = new TreeSet<>(Comparator.comparingInt(Pair::getKey));
        st.add(new Pair<>(0, S));

        while (!st.isEmpty()) {
            Pair<Integer, Integer> it = st.first();
            st.remove(it);
            
            if (distance[it.getValue()] < it.getKey())
                continue;

            for (int[] neighbor : adj.get(it.getValue())) {
                int to = neighbor[0];
                int wt = neighbor[1];

                if (distance[to] > wt + distance[it.getValue()]) {
                    if (distance[to] != INF) {
                        st.remove(new Pair<>(distance[to], to));
                    }

                    distance[to] = wt + distance[it.getValue()];
                    st.add(new Pair<>(distance[to], to));
                }
            }
        }

        return distance;
    }

    static class Pair<K, V> {
        private K key;
        private V value;

        Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        K getKey() {
            return key;
        }

        V getValue() {
            return value;
        }
    }
}
