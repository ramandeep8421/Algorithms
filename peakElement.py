public class PeakElement {

    // Function to find a peak element in an array
    public static int findPeakElement(int[] arr) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Compare the middle element with its neighbors
            if ((mid == 0 || arr[mid - 1] <= arr[mid]) && (mid == n - 1 || arr[mid + 1] <= arr[mid]))
                return arr[mid];
            else if (mid > 0 && arr[mid - 1] > arr[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }

        return -1; // Indicates peak element not found (Note: You can change the return type as needed)
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 20, 4, 1, 0 };
        int peakElement = findPeakElement(arr);
        if (peakElement != -1)
            System.out.println("Peak element: " + peakElement);
        else
            System.out.println("Peak element not found.");
    }
}
