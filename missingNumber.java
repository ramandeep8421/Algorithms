import java.util.List;

public class Solution {
    public int missingNumber(List<Integer> nums) {
        int missing = 0;
        int n = nums.size();

        for (int i = 1; i <= n; i++) {
            missing ^= i;
        }

        for (int num : nums) {
            missing ^= num;
        }

        return missing;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> nums = List.of(0, 1, 3); // Replace with your input list of numbers
        int result = solution.missingNumber(nums);
        System.out.println("Missing number: " + result);
    }
}
