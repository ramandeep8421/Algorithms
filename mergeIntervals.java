import java.util.*;

class Solution {
    public int[][] mergeIntervals(int[][] intervals) {
        //find the size of the intervals
        int n = intervals.length;

        //Sort the given array of intervals
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        //find the starting and ending indices of the interval
        int l = intervals[0][0];
        int r = intervals[0][1];

        //result array to store the final intervals
        List<int[]> res = new ArrayList<>();

        //Start iterating from the second interval 
        for(int i=1;i<n;i++){
            //check if the starting point of the
            // current interval is out of the bounds of 
            // first interval , then push the previous 
            // interval into the result array
            if(intervals[i][0] > r){
                res.add(new int[]{l,r});
                //reinitialize the current interval
                l = intervals[i][0];
                r = intervals[i][1];
            }else{
                r = Math.max(intervals[i][1],r);
            }
        }

        //push the final interval into the array
        res.add(new int[]{l,r});

        //return the result
        return res.toArray(new int[res.size()][]);
    }
}
