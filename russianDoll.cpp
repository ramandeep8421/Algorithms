#include <bits/stdc++.h>
using namespace std;




class Solution {
public:
    
     bool comp(vector<int>&a, vector<int>&b){

          if(a[0] == b[0])return a[1] < b[1];

          return a[0] < b[0];
     }
   
     int maxEnvelops(vector<vector<int>>&envelops){
          int n = envelops.size();

          sort(envelops.begin(),envelops.end(),comp);

          vector<int>dp;

          for(auto it: envelops){
              int idx = lower_bound(dp.begin(),dp.begin(),it[1]) - dp.begin();

              if(idx == n){
                 dp.push_back(it[1]);
                 continue;
              }
              dp[idx] = it[1];

          }

          return dp.size();
     }

};
