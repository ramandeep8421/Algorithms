bool dfsCycle(int node, vector<int>adj[], vector<int>&vis, vector<int>&recStack){
     vis[node]=1;
     recStack[node]=1;

     for(auto it: adj[node]){
          if(!vis[it]){
              if(dfsCycle(it, adj, vis, recStack)){
                  return true;
              }
          }else if(recStack[it]){
                return true;
          }
     }

     return false;
}


bool isCycle(int N, vector<int>adj[]){
     vector<int>vis(N+1,0),recStack(N+1,0);

     for(int i=1;i<=N;i++){
           if(!vis[i]){
                if(dfsCycle(i,adj,vis,recStack))
                  return true;
           }
     }

     return false;
}
