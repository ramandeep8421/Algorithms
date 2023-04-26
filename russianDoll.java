import java.util.*;

class Solution {

    public boolean comp(List<Integer> a, List<Integer> b) {
        if (a.get(0) == b.get(0)) {
            return a.get(1) < b.get(1);
        }
        return a.get(0) < b.get(0);
    }

    public int maxEnvelops(List<List<Integer>> envelops) {
        int n = envelops.size();

        Collections.sort(envelops, (a, b) -> comp(a, b) ? -1 : 1);

        List<Integer> dp = new ArrayList<>();

        for (List<Integer> it : envelops) {
            int idx = Collections.binarySearch(dp, it.get(1));

            if (idx < 0) {
                idx = -(idx + 1);
            }

            if (idx == dp.size()) {
                dp.add(it.get(1));
                continue;
            }

            dp.set(idx, it.get(1));
        }

        return dp.size();
    }
}


        
            
              
        
      
        
