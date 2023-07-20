class Solution {
public:
    int shortestPathBinaryMatrix(vector<vector<int>>& grid) {
            int n = grid.size();

            if(n == 1 and grid[0][0] == 0)return 1;
            
            if(grid[0][0] + grid[n-1][n-1] != 0)return -1;

            priority_queue<vector<int>, vector<vector<int>>, greater<vector<int>>>pq;

            pq.push({1,0,0});

            vector<vector<int>>dist(n, vector<int>(n, 1e9));

            dist[0][0]=1;

            int dr[] = {-1,0,1,0,1,1,-1,-1};
            int dc[] = {0,1,0,-1,1,-1,1,-1};


            while(!pq.empty()){
                  vector<int>top = pq.top();

                  pq.pop();

                  int dis = top[0];
                  int x = top[1];
                  int y = top[2];

                  for(int i=0;i<8;i++){
                       int newr = x + dr[i];
                       int newc = y + dc[i];

                       if(newr >= 0 and newr < n and newc >= 0 and newc < n and grid[newr][newc] == 0 and dis + 1 < dist[newr][newc]){
                            dist[newr][newc] = 1 + dis;

                            if(newr == n-1 and newc == n-1)
                              return 1+dis;

                            pq.push({1 + dis, newr, newc});
                       }
                  }

               
            }
             return -1;
    }
};
