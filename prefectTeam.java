import java.util.*;

class Solution {
    
    public int maxTeams(int c, int m, int x) {

        int lo = 0, hi = Math.min(c, m);

        int ans = 0;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (c + m + x - 2 * mid >= mid) {
                lo = mid + 1;
                ans = mid;
            } else {
                hi = mid;
            }
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int c = 10; // replace with your desired value
        int m = 8; // replace with your desired value
        int x = 4; // replace with your desired value
        int result = solution.maxTeams(c, m, x);
        System.out.println("Maximum number of teams: " + result);
    }
}
