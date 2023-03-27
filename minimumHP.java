import java.util.*;

class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        // Calculate the dimensions of the dungeon
        int n = dungeon.length;
        int m = dungeon[0].length;

        // Declare a dp array for the corresponding dungeon
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        // Initialize the bottom right cell
        dp[n-1][m] = dp[n][m-1] = 1;

        // Iterating over the dp and fill it 
        for (int i = n-1; i >= 0; i--) {
            for (int j = m-1; j >= 0; j--) {
                int value = Math.min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j];    
                dp[i][j] = Math.max(1, value);
            }
        }

        // The first position in the dp array contains 
        // the required answer !! 
        return dp[0][0];
    }
}

