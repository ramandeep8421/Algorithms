class Solution:
    def productExceptSelf(self, nums):
        n = len(nums)
        prefix = [1] * n
        res = 1
        prefix[0] = nums[0]

        for i in range(1, n):
            prefix[i] = prefix[i - 1] * nums[i]

        for i in range(n - 1, 0, -1):
            prefix[i] = prefix[i - 1] * res
            res *= nums[i]

        prefix[0] = res
        return prefix

# Example usage:
solution = Solution()
nums = [1, 2, 3, 4]
result = solution.productExceptSelf(nums)
print(result)
