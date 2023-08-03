import java.util.*;

public class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        pq.offer(new int[]{grid[0][0], 0, 0});

        int[][] vis = new int[n][m];

        vis[0][0] = 1;

        int[] dr = {0, -1, 0, 1, 0};

        while (!pq.isEmpty()) {
            int[] top = pq.poll();

            int t = top[0];
            int x = top[1], y = top[2];

            if (x == n - 1 && y == m - 1)
                return t;

            for (int i = 0; i < 4; i++) {
                int nx = x + dr[i];
                int ny = y + dr[i + 1];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && vis[nx][ny] == 0) {
                    vis[nx][ny] = 1;
                    pq.offer(new int[]{Math.max(t, grid[nx][ny]), nx, ny});
                }
            }
        }

        return -1;
    }
}
