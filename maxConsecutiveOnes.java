public class Solution {
    public int maxConsecutiveOnes(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        int j = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                count++;
            }

            while (count > k) {
                if (nums[j] == 0) {
                    count--;
                }
                j++;
            }

            ans = Math.max(ans, i - j + 1);
        }

        return ans;
    }
}


 
