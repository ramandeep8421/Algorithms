class Solution:
    def hammingWeight(self, n: int) -> int:
        ans = 0
        while n:
            if n & 1:
                ans += 1
            n >>= 1
        return ans

# Example usage:
solution = Solution()
n = 11  # Replace 11 with your input value
result = solution.hammingWeight(n)
print("Hamming weight:", result)
