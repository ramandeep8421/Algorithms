class Solution:
    
    def comp(self, a, b):
        if a[0] == b[0]:
            return a[1] < b[1]
        return a[0] < b[0]
    
    def maxEnvelops(self, envelops: List[List[int]]) -> int:
        n = len(envelops)
        envelops.sort(key = lambda x: (x[0], x[1]))
        
        dp = []
        
        for it in envelops:
            idx = bisect_left(dp, it[1])
            
            if idx == len(dp):
                dp.append(it[1])
                continue
            dp[idx] = it[1]
            
        return len(dp)
