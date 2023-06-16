 import java.util.*;

class Solution {

    public boolean isValid(List<Integer> weights, int capacity, int days) {
        int sum = 0;
        int cnt = 1;
        for (int i = 0; i < weights.size(); i++) {
            int it = weights.get(i);
            if (sum + it > capacity) {
                cnt++;
                sum = 0;
            }

            sum += it;
        }

        return cnt <= days;
    }

    public int minimumCapacity(List<Integer> weights, int days) {
        int n = weights.size();

        int lo = 0, hi = 0;

        for (int i = 0; i < weights.size(); i++) {
            int it = weights.get(i);
            lo = Math.max(lo, it);
            hi += it;
        }

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (isValid(weights, mid, days)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }
}
