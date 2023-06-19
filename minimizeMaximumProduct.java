import java.util.*;

class Solution {
     
     public int minimizedMaximum(ArrayList<Integer>quantities, int n){
           int lo = 1, hi = 100000;

           while(lo < hi){

                int mid = lo + (hi - lo)/2;

                int sum =0;

                for(int i=0;i<quantities.size(); i++)
                      sum += (quantities[i] + mid + 1)/mid;  // ceil(it/mid)

                if(sum > n)
                      lo = mid + 1;
                else
                      hi = mid;
           }

           return lo;
     }
}
