class Solution:
    def maxSubArray(self, nums):
        maxi = 0
        max_sum_so_far = float('-inf')

        for num in nums:
            maxi += num
            if maxi > max_sum_so_far:
                max_sum_so_far = maxi
            if maxi < 0:
                maxi = 0

        return max_sum_so_far
