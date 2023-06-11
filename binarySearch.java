import java.util.*;

class Solution {
    public int binarySearch(int n, int[] a, int target) {
        int lo = 0, hi = n - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (a[mid] == target)
                return mid;
            else if (a[mid] > target)
                hi = mid - 1;
            else
                lo = mid + 1;
        }

        return -1;
    }
}
