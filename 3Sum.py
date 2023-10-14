class Solution:
    def threeSum(self, nums):
        ans = []
        n = len(nums)
        nums.sort()  # O(nlogn)

        for i in range(n - 2):  # O(n*n) + O(nlogn) = O(n*n)
            target = -nums[i]

            if i > 0 and nums[i] == nums[i - 1]:
                continue

            j, k = i + 1, n - 1
            while j < k:
                if nums[j] + nums[k] == target:
                    ans.append([nums[i], nums[j], nums[k])

                    while j + 1 < k and nums[j] == nums[j + 1]:
                        j += 1

                    while k - 1 > j and nums[k] == nums[k - 1]:
                        k -= 1

                    j += 1
                    k -= 1
                elif nums[j] + nums[k] < target:
                    j += 1
                else:
                    k -= 1

        return ans
