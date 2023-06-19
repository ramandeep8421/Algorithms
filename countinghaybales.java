import java.util.*;

class Solution {
    public void countHaybales(ArrayList<Integer> haybales, ArrayList<Pair<Integer, Integer>> queries) {
        int n = haybales.size();
        int Q = queries.size();

        Collections.sort(haybales);

        for (Pair<Integer, Integer> query : queries) {
            int ub = upperBound(haybales, query.second);
            int lb = lowerBound(haybales, query.first);

            System.out.println(ub - lb);
        }
    }

    private int upperBound(ArrayList<Integer> haybales, int target) {
        int low = 0;
        int high = haybales.size();

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (haybales.get(mid) <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    private int lowerBound(ArrayList<Integer> haybales, int target) {
        int low = 0;
        int high = haybales.size();

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (haybales.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
