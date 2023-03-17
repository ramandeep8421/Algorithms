class Solution:
    def findMinMax(self, arr: List[int], l: int, r: int) -> List[int]:
        # Declare the min and max variables
        min_val, max_val = arr[l], arr[l]

        # Base cases
        if l == r:
            min_val, max_val = arr[l], arr[l]
        elif l + 1 == r:
            if arr[l] > arr[r]:
                min_val, max_val = arr[r], arr[l]
            else:
                min_val, max_val = arr[l], arr[r]
        # Case where the size of the array is greater than 2
        # Recursively divide the array
        else:
            mid = l + (r - l) // 2
            # Call the function for the left and right subarrays
            left_minmax = self.findMinMax(arr, l, mid)
            right_minmax = self.findMinMax(arr, mid + 1, r)

            # Compare these pairs to get the final pair for the range[l..r]
            if left_minmax[0] < right_minmax[0]:
                min_val = left_minmax[0]
            else:
                min_val = right_minmax[0]
            if left_minmax[1] < right_minmax[1]:
                max_val = right_minmax[1]
            else:
                max_val = left_minmax[1]

        return [min_val, max_val]
