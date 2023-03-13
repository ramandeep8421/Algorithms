from typing import List

class Solution:
    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
        # sizes of the arrays
        n = len(nums1)
        m = len(nums2)
        
        # sort the arrays
        nums1.sort()
        nums2.sort()

        res = []

        # declare two pointers
        i = 0
        j = 0

        while i < n and j < m:
            # if the elements at i and j match
            if nums1[i] == nums2[j]:
                if not res:
                    res.append(nums1[i])
                    i += 1
                    j += 1
                else:
                    if res[-1] == nums1[i]:
                        i += 1
                        j += 1
                    else:
                        res.append(nums1[i])
                        i += 1
                        j += 1
            else:  # if they don't match
                if nums1[i] < nums2[j]:
                    i += 1
                else:
                    j += 1

        return res

if __name__ == "__main__":
    n, m = map(int, input().split())
    nums1 = list(map(int, input().split()))
    nums2 = list(map(int, input().split()))
    obj = Solution()
    res = obj.intersection(nums1, nums2)
    for i in res:
        print(i, end=" ")
