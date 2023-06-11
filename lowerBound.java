import java.util.*;

class Solution {
    public int lower_bound(int n, int[] a, int target) {
        int lo = 0;
        int hi = n - 1;
        int ans = n;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (a[mid] >= target) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return ans;
    }
}
