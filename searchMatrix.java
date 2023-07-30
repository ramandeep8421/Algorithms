public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int lo = 0, hi = n * m - 1;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (matrix[mid / m][mid % m] < target)
                lo = mid + 1;
            else
                hi = mid;
        }
        // lower bound will be stored in lo 

        return matrix[lo / m][lo % m] == target;
    }
}
