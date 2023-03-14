import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> pascalTriangle(int N) {
        // This stores our pascal's triangle
        List<List<Integer>> res = new ArrayList<>();

        // Iterating over each row
        for (int i = 0; i < N; i++) {
            // Resizing the array
            res.add(new ArrayList<>());
            res.get(i).add(1);

            // Assign 1 to the first and last location of this array
            for (int j = 1; j < i; j++) {
                // Find the integer present in i-1th row and j-1th column
                // and add it with the integer present in i-1th row and jth column
                int val = res.get(i - 1).get(j - 1) + res.get(i - 1).get(j);
                res.get(i).add(val);
            }

            if (i > 0) {
                res.get(i).add(1);
            }
        }

        return res;
    }
}

