#include<bits/stdc++.h>
using namespace std;


class Solution {
private:
    
    /*
        Time Complexity = O(M*N)
        Space Complexity = O(M*N*K)
    */
    
    int m, n;
    vector<pair<int, int>> dirc = {{+1, 0}, {-1, 0}, {0, +1}, {0, -1}};
    
    bool isValid(int i, int j){
        if(i>=0 && i<m && j>=0 && j<n) return true;
        return false;
    }
    
public:
    int shortestPath(vector<vector<int>>& grid, int k) {
        m = grid.size(), n = grid[0].size();
        int visited[41][41][1601];
        memset(visited, false, sizeof(visited));
        queue<vector<int>> q1;
        int steps = 0;
        
        q1.push({0, 0, k});
        visited[0][0][k] = true;
        
        while(!q1.empty()){
            int size = q1.size();
            
            while(size--){
                vector<int> curr = q1.front();
                q1.pop();
                
                int obs = curr[2];
                
                if(curr[0] == m-1 && curr[1] == n-1)
                    return steps;
                
                for(auto &dir : dirc){
                    int newX = curr[0] + dir.first;
                    int newY = curr[1] + dir.second;
                    
                    if(!isValid(newX, newY)) continue;
                    
                    if(grid[newX][newY] == 0 && !visited[newX][newY][obs]){
                        q1.push({newX, newY, obs});
                        visited[newX][newY][obs] = true;
                    }else if(grid[newX][newY] == 1 && obs>0 && !visited[newX][newY][obs-1]){
                        q1.push({newX, newY, obs-1});
                        visited[newX][newY][obs-1] = true;
                    }
                }
            }
            
            steps++;
        }
        
        return -1;
    }
};
