import java.util.*;

class Main {
    
    // Taking the matrix as globally
    static int[][] dp = new int[2000][2000];
    
    // Check if possible subset with
    // given sum is possible or not
    static int subsetSum(List<Integer> a, int n, int sum) {
        
        // If the sum is zero it means
        // we got our expected sum
        if (sum == 0)
            return 1;
        
        if (n <= 0)
            return 0;
        
        // If the value is not -1 it means it
        // already call the function
        // with the same value.
        // it will save our from the repetition.
        if (dp[n - 1][sum] != -1)
            return dp[n - 1][sum];
        
        // if the value of a[n-1] is
        // greater than the sum.
        // we call for the next value
        if (a.get(n - 1) > sum)
            return dp[n - 1][sum] = subsetSum(a, n - 1, sum);
        else {
            
            // Here we do two calls because we
            // don't know which value is
            // full-fill our criteria
            // that's why we doing two calls
            return dp[n - 1][sum] = subsetSum(a, n - 1, sum) ||
                           subsetSum(a, n - 1, sum - a.get(n - 1));
        }
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int sum = input.nextInt();
        
        List<Integer> a = new ArrayList<Integer>();
        for (int i = 0; i < n; i++)
            a.add(input.nextInt());
        
        // Initializing dp array with -1
        for (int i = 0; i < 2000; i++)
            Arrays.fill(dp[i], -1);
        
        System.out.println(subsetSum(a, n, sum));
    }
}

