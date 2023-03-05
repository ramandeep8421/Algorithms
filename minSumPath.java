import java.util.*;

public class Main {
    public static int coinChange(int idx, List<Integer> coins, int amount) {
        // If the number of coins are exhausted
        if (idx >= coins.size() || amount <= 0) return 0;

        int res = -1;
        // If the value of coin at current location
        // is greater than amount
        if (coins.get(idx) > amount) {
            // Case where we are not taking the current coin
            int doNotTakeCoin = coinChange(idx+1, coins, amount);
            res = doNotTakeCoin;
        } else {
            // Two cases are there
            // case-1: where we take the coin
            // case-2: where we do not take the coin
            int takeCoin = 1 + coinChange(idx, coins, amount-coins.get(idx));
            int doNotTakeCoin = 0 + coinChange(idx+1, coins, amount);
            res = Math.min(takeCoin, doNotTakeCoin);
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int amount = scanner.nextInt();
        List<Integer> coins = new ArrayList<>();
        for (int i=0; i<n; i++) coins.add(scanner.nextInt());
        System.out.println(coinChange(0, coins, amount));
    }
}
