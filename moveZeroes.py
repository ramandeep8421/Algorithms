class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # lastNonZeroIndex
        lastNonZeroIndex = 0

        # Size of the nums array
        n = len(nums)

        # Iterate over the array
        for i in range(n):
            if nums[i] != 0:
                nums[lastNonZeroIndex] = nums[i]
                lastNonZeroIndex += 1

        # Start from the lastNonZeroIndex to the end of the array
        # and place zero at the end of the array
        for i in range(lastNonZeroIndex, n):
            nums[i] = 0
