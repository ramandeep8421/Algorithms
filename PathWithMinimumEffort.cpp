class Solution {
public:
    int minimumEffortPath(vector<vector<int>>& heights) {
          int n = heights.size();
          int m = heights[0].size();


          vector<vector<int>>distance(n, vector<int>(m, 1e9));

          distance[0][0] = 0;

          priority_queue<vector<int>, vector<vector<int>>, greater<vector<int>>>pq;

          pq.push({0,0,0});


          vector<int>dir{0,1,0,-1,0};

          while(!pq.empty()){

                 vector<int>top = pq.top();
                 pq.pop();

                 int effort = top[0];
                 int x = top[1];
                 int y = top[2];

                 if(distance[x][y] < effort)continue;

                 if(n-1 == x and m-1 == y)return effort;

                 for(int i=0;i<4;i++){
                       int newx = x + dir[i];
                       int newy = y + dir[i+1];

                       if(newx >= 0 and newy >= 0 and newx < n and newy < m){
                             int neffort = max(effort, abs(heights[newx][newy] - heights[x][y]));
                             if(neffort < distance[newx][newy]){
                                   distance[newx][newy] = neffort;
                                   pq.push({neffort, newx, newy});
                             }
                       }
                 }
          }

          return 0;
    }
};
