import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GridPaths {
    static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = row.charAt(j);
            }
        }

        if (board[0][0] == '*' || board[n - 1][n - 1] == '*') {
            System.out.println(0);
            return;
        }

        int[][] dp = new int[n][n];
        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i - 1 >= 0 && board[i][j] != '*') {
                    dp[i][j] += dp[i - 1][j];
                    dp[i][j] %= MOD;
                }
                if (j - 1 >= 0 && board[i][j] != '*') {
                    dp[i][j] += dp[i][j - 1];
                    dp[i][j] %= MOD;
                }
            }
        }

        System.out.println(dp[n - 1][n - 1]);
    }
}
