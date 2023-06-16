#include<bits/stdc++.h>
using namespace std;
#define int long long 
#define fio ios_base::sync_with_stdio(false);

 class Solution{
    
     public:
        
         int maxTeams(int c, int m, int x){

               int lo = 0, hi = min(c,m);

               int ans = 0;

               while(lo <= hi){
                   int mid = lo + (hi-lo)/2;

                   if(c + m + x - 2* mid >= mid){
                       lo = mid+1;
                       ans = mid;
                   }else{
                       hi = mid;
                   }
               }

               return ans;
         }
 };     

