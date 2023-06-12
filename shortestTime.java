import java.util.*;

class Solution {
    
    public int shortestTimeNeeded(int n, int t, List<Integer> nums) {
        int lo = 0, hi = n - 1;
        int ans = 0;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += (mid / nums.get(i));
                if (sum >= t)
                    break;
            }
            if (sum >= t) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return ans;
    }
}
