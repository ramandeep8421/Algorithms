import java.util.*;

class Solution {
    
    public long shortestTime(int n, int t, List<Integer> nums) {
        long lo = 0, hi = (long)1e18;

        long ans = 0;

        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;

            long noOfProducts = 0;

            for (int i = 0; i < n; i++) {
                noOfProducts += (mid / nums.get(i));
                if (noOfProducts >= t) {
                    break;
                }
            }
            if (noOfProducts >= t) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return ans;
    }
}
