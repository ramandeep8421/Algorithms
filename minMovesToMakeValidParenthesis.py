class Solution:
    def minAddToMakeValid(self, s: str) -> int:
        n = len(s)
        ans = 0
        balance = 0

        for i in range(n):
            balance += 1 if s[i] == '(' else -1
            if balance == -1:
                ans += 1
                balance += 1

        return ans + balance
