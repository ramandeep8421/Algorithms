#include<bits/stdc++.h>
using namespace std;
#define int long long 
#define fio ios_base::sync_with_stdio(false);

 class Solution{
    
     public:

        int minimizedMaximum(vector<int>quantities, int n){
             int lo = 1, hi = 100000;

             while(lo < hi){
                int mid = lo + (hi-lo)/2;

                int sum = 0;

                for(auto it: quantities)
                    sum += (it + mid + 1)/mid;

                if(sum > n){
                    lo = mid+1; // [mid+1, hi]
                }else{
                    hi = mid;  // [lo, mid-1]
                }
             }

             return lo;
        }
 };     


 
