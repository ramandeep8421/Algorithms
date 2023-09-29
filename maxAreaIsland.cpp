class Solution {
public:

   int cnt = 0;

     vector<int>dr{0,1,0,-1,0};

     void dfs(int i, int j, int r, int c, vector<vector<bool>>&vis, vector<vector<int>>&grid){
            vis[i][j]=true;

            cnt++;

            for(int k=0;k<4;k++){
                    int nx = i + dr[k];
                    int ny = j + dr[k+1];

                    if(nx >= 0 and ny >= 0 and nx < r and ny < c and !vis[nx][ny] and grid[nx][ny] == 1){
                             dfs(nx,ny,r,c,vis,grid);

                    }
            }
     }

 
    int maxAreaOfIsland(vector<vector<int>>& grid) {
         
         int n = grid.size();
         int m = grid[0].size();

         vector<vector<bool>>vis(n, vector<bool>(m,false));

         int ans = 0;
          
         for(int i=0;i<n;i++){
                 for(int j=0;j<m;j++){
                        if((vis[i][j] == false) and grid[i][j] == 1){
                               cnt = 0;
                               dfs(i,j,n,m,vis,grid);
                               ans = max(cnt, ans);
                        }
                 }
         }

         return ans;
    }
};
