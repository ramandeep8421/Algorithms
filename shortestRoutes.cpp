#include<bits/stdc++.h>
using namespace std;
#define int long long int 
#define INF 1000000000000000

void dijkstra(int N, vector<pair<int,int>>adj[]){
     vector<int>distance(N,INF);
     
     distance[0]=0;
     
     priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>>pq;
     
     pq.push({0,0});
     
     while(!pq.empty()){
          
          int dist = pq.top().first;
           int node = pq.top().second;
          
          pq.pop();

          if(dist > distance[node])continue;
          
          for(auto neighbor: adj[node]){
                
                int to = neighbor.second;
                int weight = neighbor.first;
                
                if(distance[to] > dist + weight){
                     distance[to] = dist+ weight;
                     pq.push({distance[to], to});
                }
          }
     }
     
     for(int i=0;i<N;i++)
       cout << distance[i] <<" ";
       
     
}

int32_t main(){
      int N,M;
      cin >> N >> M;
      
      vector<pair<int,int>>adj[N];
      
      for(int i=0;i<M;i++){
            int a,b,c;
            cin >> a >> b >> c;
            a--,b--;
            adj[a].push_back({c,b});
      }
      
      dijkstra(N,adj);
}
