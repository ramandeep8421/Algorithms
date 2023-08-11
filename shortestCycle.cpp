class Solution {
public:

    int ans = INT_MAX;

    void bfs(int node, vector<int>adj[], vector<bool>&vis, vector<int>&dis){
            queue<pair<int,int>>q;
            q.push({node,-1});
            vis[node] = true;
            dis[node] = 0;

            while(!q.empty()){
                    
                      int node = q.front().first;
                      int parent = q.front().second;

                      q.pop();

                      for(auto it: adj[node]){
                              
                              if(!vis[it]){
                                     dis[it] = dis[node] + 1;
                                     q.push({it, node});
                                     vis[it] = true;
                                     
                              }else if(it != parent){
                                      ans = min(ans, dis[it] + dis[node] + 1);
                              }
                      }
            }
    }
 
    int findShortestCycle(int n, vector<vector<int>>& edges) {
          
          vector<int>adj[n+1];

          for(auto it: edges){
                  adj[it[0]].push_back(it[1]);
                  adj[it[1]].push_back(it[0]);
          }

          for(int i=0;i<n;i++){
                  vector<bool>vis(n+1, false);
                  vector<int>dis(n+1,1e9);

                  bfs(i,adj,vis,dis);
          }

          if(ans == INT_MAX)return -1;

          return ans;
    }
};
