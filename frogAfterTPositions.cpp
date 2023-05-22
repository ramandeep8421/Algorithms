class Solution {
public:

      
      int target;
      vector<vector<int>>adjList;
      vector<int>visited;

      double dfs(int i, int t){
        

          if(i != 1 and adjList[i].size() == 1 || t == 0){
              return i == target;
           }
           visited[i] = true;

           res = 0;

            for(auto j: adjList[i]){
               if(!visited[j]){
                  res += dfs(j, t-1);
               }
           }

           //1, 0

           
          

           return res / (adjList[i].size() - (i != 1));


          
      }

      double frogPosition(int n, vector<vector<int>>&edges, int t, int target){
             adjList.resize(n);
          visited.resize(n);

           this->target = target;


          for(auto u: edges){
              adj[u[0]].push_back(u[1]);
              adj[u[1]].push_back(u[0]);
          }



          return dfs(1,t);
      }

};
