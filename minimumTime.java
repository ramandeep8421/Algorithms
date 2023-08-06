import java.util.*;

public class Solution {
    public int minimumTime(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if (Math.min(grid[0][1], grid[1][0]) > 1) return -1;

        int[][] dist = new int[n][m];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE - 1); // Similar to 1e9 + 7
        }

        dist[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0, 0, 0});

        int[] dr = {0, -1, 0, 1, 0};

        while (!pq.isEmpty()) {
            int[] top = pq.poll();

            int time = top[0];
            int x = top[1];
            int y = top[2];

            for (int i = 0; i < 4; i++) {
                int nx = x + dr[i];
                int ny = y + dr[i + 1];

                if (Math.min(nx, ny) >= 0 && nx < n && ny < m) {
                    int nTime = time + 1;

                    if (nTime < grid[nx][ny]) {
                        nTime = grid[nx][ny] + (grid[nx][ny] - nTime) % 2;
                    }

                    if (nTime < dist[nx][ny]) {
                        dist[nx][ny] = nTime;
                        pq.add(new int[]{nTime, nx, ny});
                    }
                }
            }
        }

        return dist[n - 1][m - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] grid = {
            {0, 2, 4},
            {3, 2, 1},
            {1, 1, 0}
        };

        int result = solution.minimumTime(grid);
        System.out.println("Minimum Time: " + result);
    }
}
