#include<bits/stdc++.h>
using namespace std;


class Solution
{
    public:

      bool check(vector<int>v, int k, int mid){
            if(k < n){
                 long long res = 0;
                 
                 for(int i=0;i<k;i++)res += v[i];

                long long curr_sum = res;

                 for(int i=k;i<n;i++){
                     curr_sum += (v[i] - v[i-k]);

                     res = max(res,curr_sum);
                 }

                 res += (k + (k-1))/2;

                 return res >= mid;
            }

            long long sum = 0;

            for(auto it: v)sum += it;

             sum += (n * k);

            sum -= (n * (n+1))/2;


            return  sum >= mid;
      }

      long long maximizeMushrooms(vector<int>v, int k){
              long long  lo = 1, hi = 1e18;

              while(lo < hi){
                  long long mid = lo + (hi - lo)/2;

                  if(check(v,k,mid)){
                      lo = mid;
                  }else{
                      hi = mid-1;
                  }
              }

              return lo;
      }

};
