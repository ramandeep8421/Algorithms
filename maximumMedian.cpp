#include<bits/stdc++.h>
using namespace std;
#define int long long 
#define fio ios_base::sync_with_stdio(false);

 class Solution{
    
     public:

        bool check(int x, int k , int n, vector<int>&nums){
              int operations = 0;

              for(int i=n/2;i<n;i++){
                   if(x - nums[i] >= 0){
                      operations += (x-nums[i]);
                   }
                   if(operations > k)return false;
              }

              return operations <=
        }
        
        int maximumMedian(int n, int k, vector<int>&nums){
             int lo = 1, hi = 2000000000;

             while(lo <= hi){
                 int mid = lo + (hi-lo)/2;

                 if(check(mid,k,n,nums)){
                     lo = mid;
                 }else{
                     hi = mid-1;
                 }
             }

             return lo;
        }

 };     
