#include<bits/stdc++.h>
using namespace std;
#define int long long 
#define fio ios_base::sync_with_stdio(false);

 class Solution{
    
     public:
        
         long long shortestTime(int n, int t, vector<int>&nums){
             long long lo = 0, hi = 1e18;

             long long ans  =0;

             while(lo <= hi){
                 long long mid = lo + (hi-lo)/2;

                 long long noOfProducts = 0;

                 for(int i=0;i<n;i++){
                    noOfProducts += (mid / nums[i]);
                    if(noOfProducts >= t){
                       break;
                    } 
                 }
                 if(noOfProducts >= t){
                   ans = mid;
                   hi = mid-1;
                 }else{
                   lo = mid+1;
                 }
             }

             return ans;
         }
 };     


 
