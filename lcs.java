import java.util.*;

public class Main {

    static int[][] dp = new int[1011][1011];

    static int lcs(String X, String Y, int n, int m){

        //base case
        if(n == 0 || m == 0) return 0;

        //If the last characters are matching 
        // lcs increases by 1
        if(X.charAt(n-1) == Y.charAt(m-1))
            return dp[n][m] = 1 + lcs(X, Y, n-1, m-1);

        //If the result for the indices n and m 
        // are already memoized then return the result
        if(dp[n][m] != -1) return dp[n][m];

        //Take the maximum of the result 
        // Obtained from the two cases
        //case-1: lcs of X[0..n-1] and Y[0...m]
        //case-2: lcs of Y[0...m-1] and Y[0...n]
        return dp[n][m] = Math.max(lcs(X, Y, n-1, m), lcs(X, Y, n, m-1));
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String X = sc.next();
        String Y = sc.next();
        // Initialize dp array with -1
        for(int i=0; i<1011; i++){
            Arrays.fill(dp[i], -1);
        }
        System.out.println(lcs(X, Y, X.length(), Y.length()));
    }
}
