import java.util.*;

class Solution {
    public List<Integer> findMinMax(List<Integer> arr, int l, int r) {
        // Declare the min and max variables
        int min, max;

        // Base cases
        if (l == r) {
            min = arr.get(l);
            max = arr.get(l);
        } else if (l + 1 == r) {
            if (arr.get(l) > arr.get(r)) {
                min = arr.get(r);
                max = arr.get(l);
            } else {
                min = arr.get(l);
                max = arr.get(r);
            }
        }

        // Case where the size of the array is greater than 2
        // Recursively divide the array
        else {
            int mid = l + (r - l) / 2;
            // Call the function for the left and right subarrays
            List<Integer> leftMinMax = findMinMax(arr, l, mid);
            List<Integer> rightMinMax = findMinMax(arr, mid + 1, r);

            // Compare these pairs to get the final pair for the range[l..r]
            if (leftMinMax.get(0) < rightMinMax.get(0)) {
                min = leftMinMax.get(0);
            } else {
                min = rightMinMax.get(0);
            }
            if (leftMinMax.get(1) < rightMinMax.get(1)) {
                max = rightMinMax.get(1);
            } else {
                max = leftMinMax.get(1);
            }

        }

        return Arrays.asList(min, max);
    }
}
