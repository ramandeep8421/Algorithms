#include<bits/stdc++.h>
using namespace std;
#define int long long 
#define fio ios_base::sync_with_stdio(false);

 class Solution{
    
     public:

         bool isValid(vector<int>&weights, int capacity, int days){
               int sum = 0;
               int cnt = 1;
               for(auto it: weights){
                   if(sum + it > capacity){
                      cnt++;
                      sum = 0;
                   } 

                   sum += it;
               }

               return cnt <= days;
         }
        
         int minimumCapacity(vector<int>&weights, int days){
              int n = weights.size();

              int lo = 0, hi = 0;

              for(auto it: weights){
                   lo = max(lo, it);
                   hi += it;
              }

              while(lo <= hi){
                  int mid = lo + (hi-lo)/2;

                  if(isValid(weights, mid, days)){
                       hi = mid;
                  }else{
                      lo = mid+1;
                  }
              }

              return lo;
         }
 };     


 
