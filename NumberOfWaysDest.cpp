 class Solution {
public:
    
     
    int countPaths(int n, vector<vector<int>>& roads) {

          long long MOD = 1e9 + 7;
          vector<long long>distance(n, 1e15), ways(n, 0);

          distance[0] = 0;

          vector<pair<int,long long>>adj[n];

          for(auto it: roads){
              adj[it[0]].push_back({it[1], it[2]}); 
              adj[it[1]].push_back({it[0],it[2]});
          }

          priority_queue<pair<long long,int>, vector<pair<long long,int>>, greater<pair<long long,int>>>pq;

          pq.push({0,0});

          ways[0]=1;

          while(!pq.empty()){
                 
                  pair<long long,int>p = pq.top();

                  pq.pop();

                  int node = p.second;
                  long long  dist = p.first;

                  if(distance[node] < dist)continue;

                  for(auto it: adj[node]){
                        
                        int to = it.first;
                        int wt = it.second;
                        if(distance[to] > dist + wt){
                              distance[to] = dist + wt;
                              ways[to] = ways[node];
                              pq.push({distance[to],to});
                        }
                        else if(distance[to] == dist + wt){
                               ways[to] = (ways[to] + ways[node])%(MOD);
                        }
                  }
          }

          return ways[n-1]%MOD;

    }
};
