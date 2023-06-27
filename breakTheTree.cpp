#include<bits/stdc++.h>
using namespace std;


class Solution
{
    public:

        long long max(long long a, long long b){
            return (a > b) ? a : b;
        }

        void dfs(int mid,int node , int par, vector<vector<int>>&graph, vector<int>&tot, int c){
              tot[node] = wt[node];

              vector<int>arr;

              for(auto it: graph[node]){
                  if(it != par){
                      arr.push_back(dfs(it, node, graph, tot, c));
                  }
              }

              sort(arr.begin(),arr.end());

              for(auto it: arr){

                   if(tot[node] + it > mid)
                      c++;
                    else
                       tot[node] += it;
              }

              return tot[node];
        }

        long long minimumWeightSubtree(vector<int>&wt, vector<vector<int>>&graph, int n, int k){
             vector<int>tot;
             tot.resize(n+1);

             long long mn = -1, mx = 0;

             for(auto it: wt){
                 mn = max(mn,it);
                 mx += it;
             }

             long long ans;
             long long lo = mn, hi = mx;
          
             int c = 0;

             while(lo <= hi){

                 long long mid = lo + (hi - lo)/2;
                 
                 dfs(mid,1,0,graph, wt,tot,c);

                 if(c <= k-1){
                    ans = mid;
                    hi = mid-1;
                 }else{
                     lo = mid+1;
                 }

             }

             return ans;
        }
};
