import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        Arrays.sort(nums); // O(nlogn)

        for (int i = 0; i < n - 2; i++) { // O(n*n) + O(nlogn) = O(n*n)
            int target = -nums[i];

            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int j = i + 1, k = n - 1;
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    while (j + 1 < k && nums[j] == nums[j + 1])
                        j++;

                    while (k - 1 > j && nums[k] == nums[k - 1])
                        k--;

                    j++;
                    k--;
                } else if (nums[j] + nums[k] < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return ans;
    }
}
