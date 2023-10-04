class Solution {


public:

    void dfs(vector<vector<int>>&graph, int source, int target, vector<int>path, vector<vector<int>>&ans){
          if(source == target){
                path.push_back(source);
                ans.push_back(path);
          }

          path.push_back(source);

          for(auto neighbor: graph[source]){
                 dfs(graph,neighbor, target, path, ans);
          }
    }
    vector<vector<int>> allPathsSourceTarget(vector<vector<int>>& graph) 
    {
          int target = graph.size()-1;
          int source = 0;

          vector<int>path;
          vector<vector<int>>ans;

          dfs(graph,source, target, path , ans);

          return ans;
    }
};
