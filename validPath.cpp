class Solution {
public:
    
     bool validPath(int n, vector<int>&edges, int source, int destination){
          map<int,vector<int>>graph;

          for(auto edge: edges){
              graph[edge[0]].push_back(edge[1]);
              graph[edge[1]].push_back(edge[0]);
          }

          vector<int>seen(n,false);

          seen[source]=true;

          queue<int>qu;

          qu.push(source);

          while(!qu.empty()){

              int node = qu.front();

              qu.pop();

              if(node == destination)return true;

              for(auto it: graph[node]){
                  if(!seen[it]){
                      seen[it] = true;
                      qu.push(it);
                  }
              }
          }

          return false;
     }


};
