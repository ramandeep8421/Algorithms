class Solution {
public:    

    vector<int>kahnAlgorithm(int n, int m,vector<int>adj[], vector<int>indegree){
           vector<int>order;
           queue<int>q;
        
           for(int i=0;i<n*m;i++){
                   if(indegree[i] == 0)q.push(i);
           }

           while(!q.empty()){
                
                 int node = q.front();
                 q.pop();

                 order.push_back(node);

                 for(auto neighbor: adj[node]){
                       indegree[neighbor]--;
                       if(indegree[neighbor] == 0){
                            q.push(neighbor);
                       }
                 }
           }

           return order;
           
    }
    int longestIncreasingPath(vector<vector<int>>& matrix) {
        int n = matrix.size();
        int m = matrix[0].size();

        vector<int>adj[n*m];
        vector<int>indegree(n*m);

        vector<int>dir{0,-1,0,1,0};

        for(int i=0;i<n;i++){
             for(int j=0;j<m;j++){
                   
                   for(int k=0;k<4;k++){
                          int x = i  + dir[k];
                          int y = j + dir[k+1];

                          if(x >= 0 and y >= 0 and x < n and y < m and matrix[x][y] > matrix[i][j]){
                                adj[i*m+j].push_back(x*m+y);
                                indegree[x*m+y]++;
                          }
                   }
             }
        }

        vector<int>order = kahnAlgorithm(n,m,adj,indegree);

        vector<int>dp(n*m,1);

        for(auto it: order){
             for(auto edge: adj[it]){
                   dp[edge] = max(dp[edge], dp[it] + 1);
             }
        }

        return *max_element(dp.begin(), dp.end());
    }
};
