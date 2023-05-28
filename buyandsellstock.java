public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        
        int mini = prices[0];
        int maxi = prices[1];
        int ans = 0;
        
        for (int i = 0; i < n; i++) {
            if (prices[i] < mini) {
                mini = prices[i];
                maxi = prices[i];
            }
            
            maxi = Math.max(maxi, prices[i]);
            ans = Math.max(ans, maxi - mini);
        }
        
        return ans;
    }
}

           
