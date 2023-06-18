import java.util.*;

class Solution {
    
    public boolean isValid(List<Integer> books, int curr_min, int m) {
        int run_sum = 0;
        int students = 1;

        for (int it : books) {
            if (it > curr_min)
                return false;

            if (run_sum + it > curr_min) {
                students++;
                run_sum = it;

                if (students > m)
                    return false;
            } else {
                run_sum += it;
            }
        }

        return true;
    }

    public int minimumPagesAllocation(List<Integer> books, int m) {
        int n = books.size();

        if (n > m)
            return -1;

        int lo = 0, hi = 0;

        for (int it : books)
            hi += it;

        int ans = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (isValid(books, mid, m)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return ans;
    }
}
