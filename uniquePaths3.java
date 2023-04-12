import java.util.*;

class Solution {
    // variable to store the final answer
    int ans = 0;

    // direction vectors
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};

    // function to check for the visited cells
    boolean check(int[][] grid, boolean[][] vis) {
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0 && !vis[i][j])
                    return false;
            }
        }
        return true;
    }

    // dfs function to perform the traversal
    void dfs(int i, int j, int x, int y, int[][] grid, boolean[][] vis) {
        int n = grid.length;
        int m = grid[0].length;

        if (i == x && j == y) {
            vis[i][j] = true;
            if (check(grid, vis))
                ans++;
            vis[i][j] = false;
            return;
        }
        vis[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int newr = i + dr[k], newc = j + dc[k];
            if (newr < 0 || newr >= n || newc < 0 || newc >= m || grid[newr][newc] == -1 || vis[newr][newc])
                continue;
            dfs(newr, newc, x, y, grid, vis);
        }
        vis[i][j] = false;
    }

    // function to count the unique paths
    public int uniquePathsIII(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];

        int sr = 0, sc = 0, er = 0, ec = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    sr = i;
                    sc = j;
                } else if (grid[i][j] == 2) {
                    er = i;
                    ec = j;
                }
            }
        }
        dfs(sr, sc, er, ec, grid, vis);
        return ans;
    }
}
