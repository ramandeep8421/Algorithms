import java.util.*;

public class Main {
    static int[][] dp = new int[1001][1001];

    static int rodCutting(int index, int n, List<Integer> price) {
        // Base case
        if (index == 0) {
            return n * price.get(index);
        }

        // If the result for the pair (index, n)
        // is already memoized then return the result
        if (dp[index][n] != -1) {
            return dp[index][n];
        }

        // case-1: do not make at at index
        int doNotCut = rodCutting(index - 1, n, price);

        // Case-2: Make a cut at index
        int cut = Integer.MIN_VALUE;

        // Length of the rod
        int rod_length = index + 1;

        // If the length of the rod is
        // less than the remaining size 
        // of the rod
        if (rod_length <= n) {
            cut = price.get(index) + rodCutting(index - 1, n - rod_length, price);
        }

        // Memoize the result for that particular (index, n) pair
        return dp[index][n] = Math.max(cut, doNotCut);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> price = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            price.add(sc.nextInt());
        }
        for (int i = 0; i < 1001; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(rodCutting(n - 1, n, price));
    }
}
