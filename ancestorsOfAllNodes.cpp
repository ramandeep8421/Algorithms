class Solution {
public:

      void dfs(int x, int curr, vector<vector<int>>&ans, vector<vector<int>>&graph){
          
            for(auto it: graph[curr]){
                if(graph[it].size() == 0 || graph[it].back() != x){
                    ans[it].push_back(x);
                    dfs(x, it, ans, graph);
                }
           }

         
      }
      
      vector<vector<int>>getAncestor(int n, vector<int>edges){
            vector<vector<int>>graph(n), ans(n);



            for(auto it: edges)
                graph[it[0]].push_back(it[1]);



            for(int i=0;i<n;i++)
                dfs(i,i,ans,graph);



              return ans;

      }


};
