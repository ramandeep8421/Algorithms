import java.util.*;

class Solution {
    public boolean check(List<Integer> v, int k, long mid) {
        int n = v.size();
        if (k < n) {
            long res = 0;
            for (int i = 0; i < k; i++)
                res += v.get(i);

            long curr_sum = res;

            for (int i = k; i < n; i++) {
                curr_sum += (v.get(i) - v.get(i - k));
                res = Math.max(res, curr_sum);
            }

            res += (k + (k - 1)) / 2;

            return res >= mid;
        }

        long sum = 0;

        for (int it : v)
            sum += it;

        sum += (n * k);

        sum -= (n * (n + 1)) / 2;

        return sum >= mid;
    }

    public long maximizeMushrooms(List<Integer> v, int k) {
        long lo = 1, hi = (long) 1e18;

        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;

            if (check(v, k, mid)) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }

        return lo;
    }
}
