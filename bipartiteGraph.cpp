class Solution {
 
public:
   
   bool dfs(int node, int color, vector<int>&vis, vector<vector<int>>&graph){
           vis[node]=color;
           for(auto child: graph[node]){
                   if(vis[child] == -1){
                          bool check = dfs(child, !color, vis,graph);
                          if(!check)return false;
                   }else{
                          if(vis[child] == vis[node])
                               return false;
                   }
           }

           return true;
   }
    
    bool isBipartite(vector<vector<int>>& graph) {
         
         int n = graph.size();
         vector<int>vis(n,-1);

         for(int i=0;i<n;i++){
                 if(vis[i] == -1){
                        bool check = dfs(i,0,vis,graph);
                        if(!check)return false;
                 }
         }

         return true;
    }
};
