import java.util.*;

class Solution {

    public boolean check(int x, int k, int n, List<Integer> nums) {
        long operations = 0;

        for (int i = n / 2; i < n; i++) {
            if (x - nums.get(i) >= 0) {
                operations += (x - nums.get(i));
            }
            if (operations > k)
                return false;
        }

        return operations <= k;
    }

    public int maximumMedian(int n, int k, List<Integer> nums) {
        int lo = 1, hi = 2000000000;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (check(mid, k, n, nums)) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }

        return lo;
    }
}
