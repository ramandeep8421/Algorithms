public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[258];

        int left = 0, right = 0, ans = 0;

        int n = s.length();

        while (right < n) {

            if (freq[s.charAt(right)] > 0) {
                ans = Math.max(ans, right - left);

                while (freq[s.charAt(right)] > 0) {
                    freq[s.charAt(left)]--;
                    left++;
                }
            } else {
                freq[s.charAt(right)]++;
                right++;
            }
        }

        ans = Math.max(ans, right - left);

        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String input = "abcabcbb";
        int result = solution.lengthOfLongestSubstring(input);
        System.out.println("Length of longest substring without repeating characters: " + result);
    }
}
