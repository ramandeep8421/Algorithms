import java.util.*;

class Solution {

    public void merge(ArrayList<Integer> arr, int left, int mid, int right, int[] answer) {
        // Size of the left array
        int n = mid - left + 1;

        // Size of the right array
        int m = right - mid;

        // Declare the left and right arrays
        ArrayList<Integer> l = new ArrayList<>(n);
        ArrayList<Integer> r = new ArrayList<>(m);

        // Pointers to store elements in the arrays
        for (int i = 0; i < n; i++)
            l.add(i, arr.get(left + i));
        for (int i = 0; i < m; i++)
            r.add(i, arr.get(mid + 1 + i));

        // Declare pointers to both the arrays
        int i = 0, j = 0, k = left;

        // Pointers to iterate over the arrays and prepare the final array arr
        while (i < n && j < m) {

            // If the element at ith location of l is less than the jth location of r
            // then, assign arr[i] at index k
            if (l.get(i) <= r.get(j)) {
                arr.set(k, l.get(i));
                i++;
            }
            // Otherwise assign arr[j] at the kth index
            else {
                arr.set(k, r.get(j));
                // Here, we know that we have (n-i) inversions at index i
                answer[0] += (n - i);
                j++;
            }
            k++;
        }

        // Copy remaining elements of left array if any
        while (i < n) {
            arr.set(k, l.get(i));
            i++;
            k++;
        }

        // Copy remaining elements of right array if any
        while (j < m) {
            arr.set(k, r.get(j));
            j++;
            k++;
        }

    }

    public void mergeSort(ArrayList<Integer> arr, int left, int right, int[] answer) {
        // Base condition
        if (left >= right)
            return;

        // Find the middle point
        int mid = left + (right - left) / 2;

        // Sort the left part
        mergeSort(arr, left, mid, answer);

        // Sort the right part
        mergeSort(arr, mid + 1, right, answer);

        // Merge the two parts of the array
        merge(arr, left, mid, right, answer);

    }

    public int countInversions(ArrayList<Integer> arr) {
        // Initialize the answer variable
        int[] answer = new int[1];

        // Call the mergeSort Function to call for the final answer
        mergeSort(arr, 0, arr.size() - 1, answer);

        // Return the answer from here
        return answer[0];
    }
}
