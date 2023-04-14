import java.util.*;

class Solution {
    //Function to check if two intervals overlap or not
    public boolean doesIntervalsOverlap(List<Integer> a, List<Integer> b) {
        return Math.min(a.get(1), b.get(1)) - Math.max(a.get(0), b.get(0)) >= 0;
    }

    //Function to merge two intervals
    public List<Integer> mergeInterval(List<Integer> a, List<Integer> b) {
        return Arrays.asList(Math.min(a.get(0), b.get(0)), Math.max(a.get(1), b.get(1)));
    }

    //Function to insert the interval into the intervals array
    public void insertInterval(List<List<Integer>> intervals, List<Integer> newInterval) {
        boolean isIntervalInserted = false;

        //insert the interval at the position 
        for (int i = 0; i < intervals.size(); i++) {
            if (newInterval.get(0) < intervals.get(i).get(0)) {
                intervals.add(i, newInterval);
                isIntervalInserted = true;
                break;
            }
        }

        if (!isIntervalInserted) {
            intervals.add(newInterval);
        }
    }

    //Insert the interval at right position
    public List<List<Integer>> insert(List<List<Integer>> intervals, List<Integer> newInterval) {
        //insert the interval before merging process
        insertInterval(intervals, newInterval);

        //answer array
        List<List<Integer>> answer = new ArrayList<>();

        //Iterate over all the intervals
        for (int i = 0; i < intervals.size(); i++) {
            //find the current interval
            List<Integer> currInterval = Arrays.asList(intervals.get(i).get(0), intervals.get(i).get(1));

            //merge until the list is exhausted
            // or no overlap is found
            while (i < intervals.size() && doesIntervalsOverlap(currInterval, intervals.get(i))) {
                currInterval = mergeInterval(currInterval, intervals.get(i));
                i++;
            }

            i--;
            //push the current interval into the answer array
            answer.add(currInterval);
        }

        //return the answer from here
        return answer;
    }
}
