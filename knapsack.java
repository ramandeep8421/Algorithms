import java.util.*;

public class Main {

    static int[][] dp = new int[500][500];

    static int min(int x, int y, int z){
        return Math.min(x, Math.min(y, z));
    }

    static int knapsackRec(int[] wt, int[] val, int W, int n){
        // base case
        if(n == 0 || W == 0)
            return 0;

        // when the item is not fittable in the given capacity
        if(W - wt[n-1] < 0)
            return dp[n-1][W] = knapsackRec(wt, val, W, n-1);

        // if the solution of the problem is already evaluated
        if(dp[n-1][W] != -1){
            return dp[n-1][W];
        }

        //if fittable then do the exaustive search for both options and take max
        //  of them...
        return dp[n-1][W] = Math.max(val[n-1] + knapsackRec(wt, val, W-wt[n-1], n-1), knapsackRec(wt, val, W, n-1));
    }

    static int knapsack(int[] wt, int[] val, int W, int n){

        // use a double pointer to declare the table dynamically
        int[][] dp = new int[n][W+1];

        //Iterate to initially fill the table with -1
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i], -1);

        return knapsackRec(wt, val, W, n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int W = sc.nextInt();
        int n = sc.nextInt();
        int[] wt = new int[n];
        int[] val = new int[n];

        for(int i=0;i<n;i++)
            wt[i] = sc.nextInt();

        for(int i=0;i<n;i++)
            val[i] = sc.nextInt();

        System.out.println(knapsack(wt, val, W, n));
    }
}
