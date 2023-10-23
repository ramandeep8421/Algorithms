from typing import List

class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        missing = 0
        n = len(nums)

        for i in range(1, n + 1):
            missing ^= i

        for num in nums:
            missing ^= num

        return missing

# Example usage:
solution = Solution()
nums = [0, 1, 3]  # Replace with your input list of numbers
result = solution.missingNumber(nums)
print("Missing number:", result)
