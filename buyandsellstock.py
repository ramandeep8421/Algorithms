class Solution:
    def maxProfit(self, prices):
        n = len(prices)
        
        mini = prices[0]
        maxi = prices[1]
        ans = 0
        
        for i in range(n):
            if prices[i] < mini:
                mini = prices[i]
                maxi = prices[i]
            
            maxi = max(maxi, prices[i])
            ans = max(ans, maxi - mini)
        
        return ans
