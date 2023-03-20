import java.util.*;

class Solution {
    public int maxArea(List<Integer> height) {
        // Find the size of the array
        int n = height.size();

        // Initialize two pointers i and j
        // i with first index and j with last index
        int i = 0, j = n - 1;

        // Answer variable to store the final answer
        int answer = 0;

        while (i < j) {
            // Find the height of the container
            int h = Math.min(height.get(i), height.get(j));

            // Find the area of the container
            int area = h * (j - i);

            // Update the answer
            answer = Math.max(answer, area);

            // If height at index i is greater than the height at index j
            if (height.get(i) > height.get(j)) {
                j--;
            } else {
                i++;
            }
        }

        return answer;
    }
}
