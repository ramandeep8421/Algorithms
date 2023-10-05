class Solution:
    def twoSum(self, nums, target):
        mp = {}
        
        # Map the elements to their indices
        for i, num in enumerate(nums):
            mp[num] = i
        
        for i, num in enumerate(nums):
            complement = target - num
            if complement in mp and mp[complement] != i:
                return [i, mp[complement]]
        
        return []

# Example usage:
solution = Solution()
nums = [2, 7, 11, 15]
target = 9
result = solution.twoSum(nums, target)
if len(result) == 2:
    print("Indices:", result[0], result[1])
else:
    print("No solution found.")
