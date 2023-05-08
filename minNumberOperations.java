public class Solution {
    public int minNumberOperations(int[] target) {
        int n = target.length;
        int prev = target[0];
        int ans = prev;

        for (int i = 1; i < n; i++) {
            if (target[i] > prev) {
                ans += target[i] - prev;
            }
            prev = target[i];
        }

        return ans;
    }
}
