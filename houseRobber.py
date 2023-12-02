class Solution:
    def maxMoney(self, i, nums, memo):
        if i == 0:
            memo[0] = nums[0]
            return memo[0]

        if i == 1:
            memo[1] = max(nums[1], nums[0])
            return memo[1]

        if memo[i] != -1:
            return memo[i]

        memo[i] = max(nums[i] + self.maxMoney(i - 2, nums, memo), self.maxMoney(i - 1, nums, memo))
        return memo[i]

    def rob(self, nums):
        memo = [-1] * len(nums)
        return self.maxMoney(len(nums) - 1, nums, memo)


# Example usage:
solution = Solution()
nums = [2, 7, 9, 3, 1]
result = solution.rob(nums)
print(result)  # Output: 12

