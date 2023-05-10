import java.util.*;

class Solution {
    boolean check(ArrayList<Integer> heights, int bricks, int ladders, int mid) {
        ArrayList<Integer> diff = new ArrayList<Integer>();
        for (int i = 1; i <= mid; i++) {
            if (heights.get(i) > heights.get(i-1)) {
                diff.add(heights.get(i) - heights.get(i-1));
            }
        }
        Collections.sort(diff, (a,b) -> b-a);
        int l = diff.size();
        for (int i = ladders; i < l; i++) {
            if (diff.get(i) > bricks) return false;
            bricks -= diff.get(i);
        }
        return true;
    }
    
    int furthestBuilding(ArrayList<Integer> heights, int bricks, int ladders) {
        int n = heights.size();
        int lo = 0, hi = n-1;
        while (lo < hi) {
            int mid = (lo+hi+1) / 2;
            if (check(heights, bricks, ladders, mid)) {
                lo = mid;
            } else {
                hi = mid-1;
            }
        }
        return lo;
    }
}
