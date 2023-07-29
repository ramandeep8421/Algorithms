public class Solution {

    public int[] piTable(String pat) {
        int n = pat.length();
        int[] pi = new int[n];

        int i = 1, len = 0;

        while (i < n) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                pi[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = pi[len - 1];
                } else {
                    pi[i] = 0;
                    i++;
                }
            }
        }

        return pi;
    }

    public String longestPrefix(String s) {
        int[] pi = piTable(s);

        int maxLen = pi[s.length() - 1];

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < s.length() && maxLen > 0; i++, maxLen--) {
            res.append(s.charAt(i));
        }

        return res.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "ababab";
        String longestPrefix = solution.longestPrefix(s);
        System.out.println("Longest Prefix: " + longestPrefix);
    }
}
