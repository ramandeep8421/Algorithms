import java.util.*;

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int[][] distance = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }

        distance[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0, 0, 0});

        int[] dir = {0, 1, 0, -1, 0};

        while (!pq.isEmpty()) {
            int[] top = pq.poll();

            int effort = top[0];
            int x = top[1];
            int y = top[2];

            if (distance[x][y] < effort) continue;

            if (n - 1 == x && m - 1 == y) return effort;

            for (int i = 0; i < 4; i++) {
                int newx = x + dir[i];
                int newy = y + dir[i + 1];

                if (newx >= 0 && newy >= 0 && newx < n && newy < m) {
                    int neffort = Math.max(effort, Math.abs(heights[newx][newy] - heights[x][y]));
                    if (neffort < distance[newx][newy]) {
                        distance[newx][newy] = neffort;
                        pq.add(new int[]{neffort, newx, newy});
                    }
                }
            }
        }

        return 0;
    }
}
