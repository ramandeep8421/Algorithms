class Solution {
public:
    int swimInWater(vector<vector<int>>& grid) {
          int n = grid.size();
          int m = grid[0].size();

          priority_queue<vector<int>, vector<vector<int>>, greater<vector<int>>>pq;

          pq.push({grid[0][0], 0,0});

          vector<vector<int>>vis(n, vector<int>(m,0));

          vis[0][0]=1;

          vector<int>dr{0,-1,0,1,0};

          while(!pq.empty()){

                 vector<int>top = pq.top();
                 pq.pop();

                 int t = top[0];
                 int x = top[1], y = top[2];

                 if(x == n-1 and y == n-1)return t;

                 for(int i=0;i<4;i++){
                       int nx = x + dr[i];
                       int ny = y + dr[i+1];

                       if(nx >= 0 and ny >= 0 and nx < n and ny < n and vis[nx][ny] == 0){
                             vis[nx][ny]=1;
                             pq.push({max(t,grid[nx][ny]), nx, ny});
                       }
                 }

                 
          }

          return -1;
    }
};
