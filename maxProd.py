def max_product(nums):
    if not nums:
        return 0

    n = len(nums)
    max_product = nums[0]
    min_product = nums[0]
    result = nums[0]

    for i in range(1, n):
        temp = max_product
        max_product = max(nums[i], max_product * nums[i], min_product * nums[i])
        min_product = min(nums[i], temp * nums[i], min_product * nums[i])
        result = max(result, max_product)

    return result

if __name__ == "__main__":
    n = int(input())
    nums = list(map(int, input().split()))

    max_product_value = max_product(nums)
    print("Maximum Product Subarray:", max_product_value)
