class Solution:
    def minNumberOperations(self, target: List[int]) -> int:
        n = len(target)
        prev = target[0]
        ans = prev

        for i in range(1, n):
            if target[i] > prev:
                ans += target[i] - prev
            prev = target[i]

        return ans
