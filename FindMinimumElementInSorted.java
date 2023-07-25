public class FindMinimumElementInSortedArray {
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        int[] sortedArray = {4, 5, 6, 7, 0, 1, 2};
        int minimumElement = findMin(sortedArray);
        System.out.println("The minimum element in the sorted array is: " + minimumElement);
    }
}
