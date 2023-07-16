#include<bits/stdc++.h>
using namespace std;
#define int long long
#define INF 1e18


vector<int>dijkstra(int src, int N, vector<pair<int,int>>adj[]){
      vector<int>distance(N+1, INF);
      
      distance[src] = 0;
      
      priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>>pq;
      
      pq.push({0,src});
      
      while(!pq.empty()){
           pair<int,int>p = pq.top();
           pq.pop();
           
           int node = p.second;
           int cost = p.first;
           
           if(distance[node] < cost)continue;
           
           for(auto neighbor: adj[node]){
                int to = neighbor.first;
                int c = neighbor.second;
                
                if(distance[to] > c + distance[node]){
                      distance[to] = c + distance[node];
                      
                      pq.push({distance[to], to});
                }
           }
      }
      
      return distance;
}

int32_t main(){
    
     int n,m;
     cin >> n >> m;
     vector<pair<int,int>>adj[n+1], adj_rev[n+1];
     
     for(int i=0;i<m;i++){
          int a,b,c;
          cin >> a >> b >> c;
          adj[a].push_back({b,c});
          adj_rev[b].push_back({a,c});
     }
     
     //city 1
     // city n
     
     vector<int>minCosts = dijkstra(1,n, adj);
     vector<int>minCostsRev = dijkstra(n,n,adj_rev);
     
     int ans = INF;
     
     for(int i=1;i<=n;i++){
           for(auto neighbor: adj[i]){
                 
                 int to = neighbor.first;
                 int c = neighbor.second;
                if(minCosts[i] == INF || minCostsRev[to] == INF)continue;
                
                ans = min(ans, minCosts[i] + c/2 + minCostsRev[to]);
           }
     }
     
     cout << ans;
}


