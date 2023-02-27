import java.util.*;

class Main {
    public static void lcs(String X, String Y, int m, int n) {

        int[][] dp = new int[2][n + 1];
        int result = 0;

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    dp[i % 2][j] = 0;
                else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i % 2][j] = dp[(i - 1) % 2][j - 1] + 1;
                    if (dp[i % 2][j] > result) {
                        result = dp[i % 2][j];
                    }
                    result = Math.max(result, dp[i][j]);
                } else {
                    dp[i % 2][j] = 0;
                }
            }
        }

        System.out.println(result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String x = sc.next();
        String y = sc.next();
        lcs(x, y, x.length(), y.length());
    }
}
