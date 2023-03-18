import java.util.*;

class Solution {

    public int findLongestConseqSubseq(int[] arr) {
        
        // Set to store the elements of arr
        Set<Integer> st = new HashSet<>();

        // Insert the elements into the hashset
        for(int i=0; i<arr.length; i++) {
            st.add(arr[i]);
        }

        // Variable to find the longest consecutive subsequence
        int ans = 1;

        // size of the input array
        int n = arr.length;

        for(int i=0; i<n; i++) {
            // Check if the previous element arr[i]-1 
            // is present in the sequence, if present 
            // then this is not the starting point of the 
            // subsequence
            if(st.contains(arr[i]-1)) {
                continue;
            } else {
                // Otherwise this is the starting point of the 
                // subsequence
                int j = arr[i];
                while(st.contains(j)) {
                    j++;
                }

                ans = Math.max(ans, j-arr[i]);
            }
        }

        return ans;
    }
}
