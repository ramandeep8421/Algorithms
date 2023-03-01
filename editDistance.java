import java.util.*;

public class Main {

    static int[][] dp = new int[500][500];

    static int min(int x, int y, int z){
        return Math.min(x, Math.min(y, z));
    }

    static int editDistance(String X, String Y, int m, int n){

        // If the first string is exhausted then append all characters of the second string
        if(m == 0) return dp[m][n] = n;

        // If the second string is exhausted then append all characters of the first string
        if(n == 0) return dp[m][n] = m;

        // In case the result is already computed
        if(dp[m][n] != -1) return dp[m][n];

        // If the last characters match, then move to the right by one
        if(X.charAt(m-1) == Y.charAt(n-1)) dp[m][n] = editDistance(X, Y, m-1, n-1);

        // Otherwise explore all three cases and take the minimum of the three
        else dp[m][n] = 1 + min(editDistance(X, Y, m, n-1),  // Insert
                                editDistance(X, Y, m-1, n),  // Delete
                                editDistance(X, Y, m-1, n-1) // Replace
                               );
        return dp[m][n];

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String X = sc.next();
        String Y = sc.next();

        for(int i=0; i<500; i++)
            for(int j=0; j<500; j++)
                dp[i][j] = -1;

        System.out.println(editDistance(X, Y, X.length(), Y.length()));
    }
}

