public class Solution {
    private int cnt = 0;
    private int[] dr = {0, 1, 0, -1, 0};

    private void dfs(int i, int j, int r, int c, boolean[][] vis, int[][] grid) {
        vis[i][j] = true;
        cnt++;

        for (int k = 0; k < 4; k++) {
            int nx = i + dr[k];
            int ny = j + dr[k + 1];

            if (nx >= 0 && ny >= 0 && nx < r && ny < c && !vis[nx][ny] && grid[nx][ny] == 1) {
                dfs(nx, ny, r, c, vis, grid);
            }
        }
    }

    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && grid[i][j] == 1) {
                    cnt = 0;
                    dfs(i, j, n, m, vis, grid);
                    ans = Math.max(cnt, ans);
                }
            }
        }

        return ans;
    }
}
