#include<bits/stdc++.h>
using namespace std;
#define int long long 
#define fio ios_base::sync_with_stdio(false);

 class Solution{
    
     public:

        int shortestTimeNeeded(int n, int t, vector<int>&nums){
             int lo = 0, hi = n-1;

             while(lo <= hi){
                int mid = lo + (hi - lo)/2;
                int sum = 0;
                for(int i=0;i<n;i++){
                    sum += (mid/nums[i]);
                    if(sum >= t)break;
                }
                if(sum >= t){
                    ans = mid;
                    hi = mid-1;
                }else{
                    lo = mid+1;
                }
             }

             return ans;
        }
 };     


 
