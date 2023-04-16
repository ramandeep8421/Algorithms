public class Solution {

    public int minAddToMakeValid(String s) {
        int n = s.length();
        int ans = 0, balance = 0;

        for (int i = 0; i < n; i++) {
            balance += (s.charAt(i) == '(') ? 1 : -1;
            if (balance == -1) {
                ans++;
                balance++;
            }
        }

        return ans + balance;
    }

}
 
