#include<bits/stdc++.h>
using namespace std;


class Solution
{
    public:

       bool check(int mid, vector<int>a){
            int n = a.size();

            vector<int>b(n);

            for(int i=0;i<n;i++){
                if(a[i] >= mid)b[i] = 1;
                else b[i] = -1;
            }

            for(int i=1;i<n;i++)b[i] += b[i-1];

            int mx = b[k-1], mn = 0; // 0 -- i-k

            for(int i=k;i<n;i++){
                 mn = min(mn, b[i-k]); // minimum in 0 .... i-k
                 mx = max(mx, b[i] - mn); // maxumum segment sum from 0 to i
            }
       
            return mx > 0;

       }

       int maxMedian(vector<int>a, int k){
           int lo = 1, hi = a.size() + 1;

           while(lo < hi){
               int mid = lo + (hi - lo)/2;

               if(check(mid,a)){
                  lo = mid;
               }else{
                  hi = mid;
               }
           }
           return lo;
       }

};
