class Solution {
public:
    int minimumTime(vector<vector<int>>& grid) {
        int n = grid.size();
        int m = grid[0].size();

        if(min(grid[0][1], grid[1][0]) > 1)return -1;

        vector<vector<int>>dist(n, vector<int>(m, 1e9 + 7));

        dist[0][0]=0;

        priority_queue<vector<int>, vector<vector<int>>, greater<vector<int>>>pq;

        pq.push({0,0,0});

        int dr[] = {0,-1,0,1,0};

        while(!pq.empty()){

                vector<int>top = pq.top();

                pq.pop();

                int time = top[0];
                int x = top[1];
                int y = top[2];

                for(int i = 0;i<4;i++){
                        int nx = x + dr[i];
                        int ny = y + dr[i+1];

                        if(min(nx,ny) >= 0 and nx < n and ny < m){
                               
                                int nTime = time + 1;
                               
                                if(nTime < grid[nx][ny])
                                    nTime = grid[nx][ny] + (grid[nx][ny] - nTime)%2;


                                if(nTime < dist[nx][ny]){
                                        dist[nx][ny] = nTime;
                                        pq.push({nTime, nx, ny});
                                }
                                
                        }
                }
               
        }

        return dist.back().back();
    }
};
