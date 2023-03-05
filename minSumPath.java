import java.util.*;

public class Main {
    static int minPathSum(int i, int j, int[][] grid, int[][] dp) {
        // Base case-1
        if (i == 0 && j == 0) {
            return grid[i][j];
        }

        // Base case-2
        if (i < 0 || j < 0) {
            return 10000007;
        }

        // Memoization case
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // Recur for the path in 0 to i-1
        int up = grid[i][j] + minPathSum(i-1, j, grid, dp);

        // Recur for the path in 0 to j-1
        int left = grid[i][j] + minPathSum(i, j-1, grid, dp);

        // Return the result
        return dp[i][j] = Math.min(up, left);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] grid = new int[n][m];
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
                dp[i][j] = -1;
            }
        }

        System.out.println(minPathSum(n-1, m-1, grid, dp));
    }
}

