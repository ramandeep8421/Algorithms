class Solution {
public:

        vector<vector<int>> highestPeak(vector<vector<int>>&water){
             int n = water.size(), m = water[0].size();

             vector<vector<int>>ans(n, vector<int>(m,-1));

             queue<pair<int,int>>qu;

             for(int i=0;i<n;i++){
                 for(int j=0;j<m;j++){
                    if(water[i][j] == 1){
                        ans[i][j]=0;
                        qu.push({i,j});
                    }
                 }
             }

             while(!qu.empty()){

                  pair<int,int>p = qu.front();

                  qu.pop();

                  int x = p.first , y = p.second;

                  int v = ans[x][y];

                  vector<int>temp = {-1,0,1,0,-1};

                  for(int i=0;i<n;i++){
                       if(x + temp[i] >= 0 and x + temp[i] < n and y + temp[i+1] < m and y + temp[i+1] >= 0){
                             if(ans[x + temp[i]][y + temp[i+1]] == -1){
                                  ans[x + temp[i]][y + temp[i+1]] = v + 1;
                                  qu.push({x + temp[i], y + temp[i+1]});
                             }
                       }
                  }
             }

             return ans;

        }

};
