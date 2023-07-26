import java.util.ArrayList;

public class Solution {

    private int lowerBound(ArrayList<Integer> nums, int target) {
        int lo = 0, hi = nums.size() - 1;
        int ans = nums.size();

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums.get(mid) >= target) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return ans;
    }

    public ArrayList<Integer> searchRange(ArrayList<Integer> nums, int target) {
        int first = lowerBound(nums, target);
        int last = lowerBound(nums, target + 1) - 1;

        if (first < nums.size() && nums.get(first) == target) {
            ArrayList<Integer> result = new ArrayList<>();
            result.add(first);
            result.add(last);
            return result;
        }

        return new ArrayList<>();
    }
}
