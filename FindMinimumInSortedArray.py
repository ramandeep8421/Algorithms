def find_min(nums):
    left = 0
    right = len(nums) - 1

    while left < right:
        mid = left + (right - left) // 2

        if nums[mid] > nums[right]:
            left = mid + 1
        else:
            right = mid

    return nums[left]

if __name__ == "__main__":
    sorted_array = [4, 5, 6, 7, 0, 1, 2]
    minimum_element = find_min(sorted_array)
    print("The minimum element in the sorted array is:", minimum_element)
