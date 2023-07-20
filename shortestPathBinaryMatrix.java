import java.util.*;

public class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if (n == 1 && grid[0][0] == 0)
            return 1;

        if (grid[0][0] + grid[n - 1][n - 1] != 0)
            return -1;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        pq.add(new int[]{1, 0, 0});

        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], 1_000_000_000);
        }

        dist[0][0] = 1;

        int[] dr = {-1, 0, 1, 0, 1, 1, -1, -1};
        int[] dc = {0, 1, 0, -1, 1, -1, 1, -1};

        while (!pq.isEmpty()) {
            int[] top = pq.poll();

            int dis = top[0];
            int x = top[1];
            int y = top[2];

            for (int i = 0; i < 8; i++) {
                int newr = x + dr[i];
                int newc = y + dc[i];

                if (newr >= 0 && newr < n && newc >= 0 && newc < n && grid[newr][newc] == 0 && dis + 1 < dist[newr][newc]) {
                    dist[newr][newc] = 1 + dis;

                    if (newr == n - 1 && newc == n - 1)
                        return 1 + dis;

                    pq.add(new int[]{1 + dis, newr, newc});
                }
            }
        }
        return -1;
    }

    // Example usage:
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {{0, 1, 0}, {0, 0, 1}, {1, 1, 0}};
        System.out.println(solution.shortestPathBinaryMatrix(grid));
    }
}
