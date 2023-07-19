class Solution {
public:
               int minCost(vector<vector<int>>&grid){
                
                 int n = grid.size();
                 int m = grid[0].size();
                 
                 vector<vector<int>>cost(n, vector<int>(m,INT_MAX));
                 
                 cost[0][0] = 0;
                 priority_queue<vector<int>, vector<vector<int>>, greater<vector<int>>>pq;
                 
                 
                 pq.push({0,0,0});
                 
                 
                 vector<int>dir{0,1,0,-1,0};
                 
                 map<pair<int,int>,int>mpDir;
                 
                 mpDir[{0,1}] = 1;
                 mpDir[{1,0}] = 3;
                 mpDir[{0,-1}] = 2;
                 
                 mpDir[{-1,0}] = 4;
                 
                 while(!pq.empty()){
                     
                        vector<int>top = pq.top();
                        pq.pop();
                        
                        if(top[1] == n-1 and top[2] == m-1)return cost[top[1]][top[2]];
                        
                        
                        if(top[0] > cost[top[1]][top[2]])continue;
                        
                        
                        for(int i=0;i<4;i++){
                            
                              int x = top[1] + dir[i];
                              int y = top[2] + dir[i+1];
                              
                              if(x >= 0 and y >= 0 and x < n and y < m){
                                  
                                  int dirCost = 0;
                                  
                                  if(grid[top[1]][top[2]] != mpDir[{dir[i],dir[i+1]}]){
                                      
                                      dirCost = 1;
                                  }
                                  
                                  int newCost = top[0] + dirCost;
                                  
                                  if(newCost < cost[x][y]){
                                        cost[x][y] = newCost;
                                        pq.push({newCost,x,y});
                                  }
                              }
                        }
                        
                        
                        
                        
                 }
                 return cost[n-1][m-1];
            }

};
