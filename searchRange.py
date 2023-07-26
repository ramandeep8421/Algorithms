class Solution:

    def lower_bound(self, nums, target):
        lo = 0
        hi = len(nums) - 1
        ans = len(nums)

        while lo <= hi:
            mid = lo + (hi - lo) // 2

            if nums[mid] >= target:
                ans = mid
                hi = mid - 1
            else:
                lo = mid + 1

        return ans

    def searchRange(self, nums, target):
        first = self.lower_bound(nums, target)
        last = self.lower_bound(nums, target + 1) - 1

        if first < len(nums) and nums[first] == target:
            return [first, last]

        return [-1, -1]
