import java.util.*;

public class Solution {

    public int minCost(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] cost = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }

        cost[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0, 0});

        int[] dir = {0, 1, 0, -1, 0};

        Map<Pair<Integer, Integer>, Integer> mpDir = new HashMap<>();
        mpDir.put(new Pair<>(0, 1), 1);
        mpDir.put(new Pair<>(1, 0), 3);
        mpDir.put(new Pair<>(0, -1), 2);
        mpDir.put(new Pair<>(-1, 0), 4);

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int x = top[1];
            int y = top[2];

            if (x == n - 1 && y == m - 1) {
                return cost[x][y];
            }

            if (top[0] > cost[x][y]) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int newX = x + dir[i];
                int newY = y + dir[i + 1];

                if (newX >= 0 && newY >= 0 && newX < n && newY < m) {
                    int dirCost = 0;

                    if (grid[x][y] != mpDir.get(new Pair<>(dir[i], dir[i + 1]))) {
                        dirCost = 1;
                    }

                    int newCost = top[0] + dirCost;

                    if (newCost < cost[newX][newY]) {
                        cost[newX][newY] = newCost;
                        pq.offer(new int[]{newCost, newX, newY});
                    }
                }
            }
        }

        return cost[n - 1][m - 1];
    }

    private static class Pair<T1, T2> {
        T1 first;
        T2 second;

        public Pair(T1 first, T2 second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) obj;
            return Objects.equals(first, pair.first) &&
                    Objects.equals(second, pair.second);
        }
    }
}
