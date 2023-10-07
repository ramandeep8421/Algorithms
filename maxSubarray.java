public class Solution {
    public int maxSubArray(int[] nums) {
        int maxi = 0;
        int max_sum_so_far = Integer.MIN_VALUE;

        for (int num : nums) {
            maxi += num;
            if (maxi > max_sum_so_far) {
                max_sum_so_far = maxi;
            }
            if (maxi < 0) {
                maxi = 0;
            }
        }

        return max_sum_so_far;
    }
}
